package com.sun.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.model.Account;
import com.sun.model.Board;
import com.sun.model.Holdings;
import com.sun.model.Member;
import com.sun.model.TradingHistory;
import com.sun.service.AccountService;
import com.sun.service.BoardService;
import com.sun.service.HoldingService;
import com.sun.service.MemberService;
import com.sun.service.StockService;
import com.sun.service.TradingHistoryService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService ms;
	@Autowired
	private AccountService as;
	@Autowired
	private TradingHistoryService ths;
	@Autowired
	private HoldingService hs;
	@Autowired
	private StockService ss;
	@Autowired
	private BoardService bs;

	/**
	 * 사용자용
	 */
	@RequestMapping("/joinForm")
	public String joinForm(HttpSession session) {

		session.removeAttribute("authUser");
		session.removeAttribute("depositSum");

		return "member/joinForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Member member, Model model, HttpSession session) {

		int result = 0; 
		
		member.setIsAdmin("n");
		
		result = errorCheck(member);
		if(result < 0)  {
			model.addAttribute("result", result);
			return "error/error";
		}

		result = ms.join(member);
		model.addAttribute("result", result);

		return "member/join";
	}

	private int errorCheck(Member member) {
		if(member.getGender().equals("none")) {
			return -103;
		}
		Member temp = ms.getMemberById(member.getId());
		if(temp != null) {
			return -101;
		}
		if(member.getPassword().length() < 6) {
			return -102; 
		}
		
		return 0;
	}

	@RequestMapping("/loginForm")
	public String loginForm() {

		return "member/loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String password, Model model, HttpSession session) {

		Member tryLogin = new Member();
		tryLogin.setId(id);
		tryLogin.setPassword(password);

		Member member = ms.getMember(tryLogin);

		if (member != null) {

			model.addAttribute("result", 1);
			setDepositSum(member, session);
			session.setAttribute("authUser", member);

		} else {
			model.addAttribute("result", 0);
		}

		return "member/login";

	}

	@RequestMapping("/mymenu")
	public String mymenu(HttpSession session, Model model) {

		Member member = (Member) session.getAttribute("authUser");
		
		if(member == null) {
			return "member/loginForm";
		}
		
		hs.treat(member.getIdx());
		List<Board> boardList = bs.getBoardListByMember(member);
		List<Account> accountList = as.getAllAccount(member.getIdx());
		List<TradingHistory> tradingHistoryList = ths.getListByM_idx(member.getIdx());
		List<Holdings> holdingsList = hs.getListByM_idx(member.getIdx());
		for (TradingHistory tradingHistory : tradingHistoryList) {
			String name = ss.getStockName(tradingHistory.getS_code());
			String action = tradingHistory.getAction();
			if (action.equals("p")) {
				tradingHistory.setAction("매수");
			}
			if (action.equals("s")) {
				tradingHistory.setAction("매도");
			}
			tradingHistory.setS_name(name);
		}
		for (Holdings holdings : holdingsList) {
			String name = ss.getStockName(holdings.getS_code());
			holdings.setS_name(name);
		}

		model.addAttribute("boardList", boardList);
		model.addAttribute("accountList", accountList);
		model.addAttribute("tradingHistoryList", tradingHistoryList);
		model.addAttribute("holdingsList", holdingsList);

		return "member/mymenu";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.removeAttribute("authUser");
		session.removeAttribute("depositSum");

		return "member/logout";
	}

	private void setDepositSum(Member member, HttpSession session) {

		List<Account> accountList = as.getAllAccount(member.getIdx());

		if (accountList != null) {
			int depositSum = 0;
			for (Account ac : accountList) {
				depositSum += ac.getBalance();
			}
			session.setAttribute("depositSum", depositSum);
		}

	}

	/**
	 * 관리자용
	 */
	@RequestMapping("/master")
	public String masterMenu() {
		return "/member/master";
	}

}
