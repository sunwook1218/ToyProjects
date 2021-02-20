package com.mtcm.sample.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtcm.sample.service.AjaxService;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired
	private AjaxService as;

	@RequestMapping("/test")
	public void doAjax(HttpServletRequest request, HttpServletResponse response) {

		try {
			response.getWriter().write("");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
