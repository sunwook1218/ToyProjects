package com.sun.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.service.CRUDService;

@Controller
@RequestMapping("/crud")
public class CRUDController {

	@Autowired
	private CRUDService service;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@Param("option") Integer option, @Param("name1") String name1, @Param("age1") Integer age1,
			@Param("name2") String name2, @Param("age2") Integer age2) {
		
		service.aopTestProcess(option, name1, age1, name2, age2);

		return "redirect:/view/home";
	}

	@RequestMapping(value = "/delete")
	public String delete() {

		service.delete();

		return "redirect:/view/home";
	}

}
