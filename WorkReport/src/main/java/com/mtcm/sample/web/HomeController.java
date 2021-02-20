package com.mtcm.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		
		return "main/home";
	}
	
	
	

}
