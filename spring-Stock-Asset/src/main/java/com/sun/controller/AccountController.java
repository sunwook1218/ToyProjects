package com.sun.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.model.Account;
import com.sun.model.Member;
import com.sun.service.AccountService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/account")
@Log4j
public class AccountController {

	@Autowired
	private AccountService as;

	@RequestMapping("/createForm")
	public String createForm(HttpSession session) {

		if (session.getAttribute("authUser") == null) {
			return "member/login";
		}

		return "account/createForm";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model, Account account, HttpSession session) {

		Member member = (Member) session.getAttribute("authUser");

		account.setM_idx(member.getIdx());

		int result = as.create(account);

		log.info("Account opening ----->" + member.getIdx());

		List<Account> accountList = as.getAllAccount(member.getIdx());

		int depositSum = 0;

		for (Account ac : accountList) {
			depositSum = ac.getBalance() + depositSum;
		}
		
		session.setAttribute("depositSum", depositSum);

		model.addAttribute("result", result);
		
		return "account/create";
	}

	@RequestMapping("/manage")
	public String manage(HttpSession session, Model model) {

		Member member = (Member) session.getAttribute("authUser");

		if (member == null) {
			return "member/login";
		}
		
		List<Account> accountList = as.getAllAccount(member.getIdx());
		
		model.addAttribute("accountList", accountList);

		return "account/manage";
	}

}
