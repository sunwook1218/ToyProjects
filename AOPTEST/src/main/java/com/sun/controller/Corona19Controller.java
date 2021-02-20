package com.sun.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.model.Item;
import com.sun.service.Corona19Service;

@Controller
@RequestMapping("/corona19")
public class Corona19Controller {
	
	@Autowired
	private Corona19Service corona19Service;
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model, @Param("startDate") String startDate, @Param("endDate") String endDate) throws UnsupportedEncodingException, IOException {
		
		if(startDate == null | endDate == null) {
			startDate="20201110";
			endDate="20201115";
		}
		
		endDate = endDate.replaceAll("-", "");
		startDate = startDate.replaceAll("-", "");
		
		List<Item> itemList = corona19Service.getitemList(startDate, endDate);
		
		model.addAttribute("itemList", itemList);
		
		return "corona19/dashboard";
	}

}
