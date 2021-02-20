package com.sun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.model.Member;
import com.sun.service.CRUDService;

@Controller
@RequestMapping("/view")
public class HomeController {

	@Autowired
	private CRUDService service;

	@RequestMapping("/home")
	public String home(Model model) {

		List<Member> allMemberList = service.selectAll();

		model.addAttribute("allMemberList", allMemberList);

		return "home";

	}

}
