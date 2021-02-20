package com.sun.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.model.Account;
import com.sun.model.Holdings;
import com.sun.model.InvestData;
import com.sun.model.Member;
import com.sun.model.PagingBean;
import com.sun.model.Quotation;
import com.sun.model.Stock;
import com.sun.model.TradingHistory;
import com.sun.scrapper.TableScrapper;
import com.sun.service.AccountService;
import com.sun.service.HoldingService;
import com.sun.service.StockService;
import com.sun.service.TradingHistoryService;

@Controller
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService ss;
	@Autowired
	private TradingHistoryService ths;
	@Autowired
	private AccountService as;
	@Autowired
	private HoldingService hs;

	int errorPhase = 0;

	@RequestMapping("/searchForm")
	public String searchForm(Model model, String code) {

		return "stock/searchForm";
	}

	@RequestMapping("/search")
	public String search(Model model, String query, Integer page) {

		int rowPerPage = 20;

		if (page == null || page == 0) {
			page = 1;
		}
		Stock forSearch = new Stock();
		int startRow = (page - 1) * rowPerPage + 1;
		int endRow = startRow + rowPerPage - 1;
		forSearch.setStartRow(startRow);
		forSearch.setEndRow(endRow);
		forSearch.setSearch(query);

		List<Stock> stockList = ss.getList(forSearch);
		int total = ss.getTotal(query);
		
		PagingBean pb = new PagingBean(page, rowPerPage, total);

		model.addAttribute("stockList", stockList);
		model.addAttribute("pb", pb);

		return "stock/search";
	}

	@RequestMapping("/detail")
	public String detail(Model model, String code, HttpSession session) {

		Member member = (Member) session.getAttribute("authUser");

		List<Quotation> list = ss.getQuotationList(code);
		String s_name = ss.getStockName(code);

		int reserve = 0;

		if (member != null) {
			Holdings holdings = hs.getHoldingByCode(new InvestData(member.getIdx(), code));

			if (holdings != null) {
				reserve = holdings.getAmount();
			}
		}
	
		model.addAttribute("list", list);
		model.addAttribute("s_name", s_name);
		model.addAttribute("reserve", reserve);
		
		try {
			update(model, code);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "stock/detail";
	}

	@RequestMapping("/update")
	public String update(Model model, @Param(value = "code") String code)
			throws ClassNotFoundException, SQLException, IOException {

		try {
			TableScrapper.process60(code);
		} catch (Exception e) {

		}

		List<Quotation> list = ss.getQuotationList(code);

		model.addAttribute("list", list);

		return "stock/update";
	}

	/**
	 * trading시에 관리해야 할 것 ths테이블에 내역 기록 account 잔액 변동 holdings 내용 변동
	 */
	@RequestMapping(value = "/trading", method = RequestMethod.POST)
	public String trading(TradingHistory th, Model model, HttpSession session) {

		Member member = (Member) session.getAttribute("authUser");
		if (member == null) {
			return "member/loginForm";
		}
		// error check

		if (th.getAmount() == 0 || th.getAmount() < 0) {
			model.addAttribute("result", -301);
			return "error/error";
		}
		if (th.getAmount() > 100000000) {
			model.addAttribute("result", -302);
			return "error/error";
		}

		Holdings holdings = hs.getHoldingByCode(new InvestData(member.getIdx(), th.getS_code()));
		Account account = as.getOneAccount(member.getIdx());

		if (th.getAction().equals("s")) {
			int h_amount = holdings.getAmount();

			if (h_amount < th.getAmount()) {
				model.addAttribute("result", -401);
				return "error/error";
			}
		}

		if (th.getAction().equals("p")) {
			int balance = account.getBalance();
			if (balance < (th.getAmount() * th.getPrice())) {
				model.addAttribute("result", -402);
				return "error/error";
			}
		}
		// error check done

		accountUpdate(member, session, th);

		holdingsUpdate(member, session, th);

		int m_idx = member.getIdx();

		th.setM_idx(m_idx);

		int result = ths.trading(th);

		System.out.println(th.toString());

		model.addAttribute("result", result);
		model.addAttribute("th", th);

		return "stock/trading";
	}

	private void holdingsUpdate(Member member, HttpSession session, TradingHistory th) {

		Holdings holdings = hs.getHoldingByCode(new InvestData(member.getIdx(), th.getS_code()));

		if (holdings == null) {
			if (th.getAction().equals("s")) {
			}
			Holdings newHoldings = new Holdings();
			newHoldings.setM_idx(member.getIdx());
			newHoldings.setAmount(th.getAmount());
			newHoldings.setP_price(th.getPrice());
			newHoldings.setS_code(th.getS_code());
			hs.insertNew(newHoldings);
		} else {
			if (th.getAction().equals("p")) {
				holdings.setAmount(holdings.getAmount() + th.getAmount());
				holdings.setP_price(calcP_price(holdings, th, th.getAction()));
				hs.update(holdings);
			}
			if (th.getAction().equals("s")) {
				if ((holdings.getAmount() - th.getAmount()) == 0) {
					hs.delete(holdings);
				}
				holdings.setAmount(holdings.getAmount() - th.getAmount());
				holdings.setP_price(calcP_price(holdings, th, th.getAction()));
				hs.update(holdings);

			}
		}
	}

	private int calcP_price(Holdings holdings, TradingHistory th, String action) {
		if (action.equals("p")) {
			return ((holdings.getAmount() * holdings.getP_price()) + (th.getAmount() * th.getPrice()))
					/ (holdings.getAmount() + th.getAmount());
		}
		if (action.equals("s")) {
			return ((holdings.getAmount() * holdings.getP_price()) - (th.getAmount() * th.getPrice()))
					/ (holdings.getAmount() + th.getAmount());
		}
		return -1;
	}

	private int accountUpdate(Member member, HttpSession session, TradingHistory th) {

		Account oneAccount = as.getOneAccount(member.getIdx());

		if (th.getAction().equals("p")) {

			oneAccount.setBalance(oneAccount.getBalance() - (th.getAmount() * th.getPrice()));

			as.update(oneAccount);

			depositUpdate(member, session);

		} else if (th.getAction().equals("s")) {

			oneAccount.setBalance(oneAccount.getBalance() + (th.getAmount() * th.getPrice()));

			as.update(oneAccount);

			depositUpdate(member, session);

		}

		return 0;

	}

	private void depositUpdate(Member member, HttpSession session) {
		List<Account> accountList = as.getAllAccount(member.getIdx());

		if (accountList != null) {
			int depositSum = 0;
			for (Account ac : accountList) {
				depositSum += ac.getBalance();
			}
			session.removeAttribute("depositSum");
			session.setAttribute("depositSum", depositSum);
		}
	}

}
