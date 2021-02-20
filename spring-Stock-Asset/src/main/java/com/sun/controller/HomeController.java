package com.sun.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping("/")
	public String home(Model model) throws IOException {
		return "index";
	}
	
	@RequestMapping("/e")
	public String element() {
		return "elements";
	}
	
	@RequestMapping("/update/log")
	public String updateLog() {
		return "update/log";
	}

}
