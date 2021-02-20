package com.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fund")
public class FundController {

	@RequestMapping("/list")
	public String list(Model model) {
		return "fund/list";
	}

}
