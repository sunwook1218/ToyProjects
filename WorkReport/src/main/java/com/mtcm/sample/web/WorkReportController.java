package com.mtcm.sample.web;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtcm.sample.service.WorkReportService;
import com.mtcm.sample.service.vo.Report;
import com.mtcm.sample.service.vo.ReportDetail;

@Controller
@RequestMapping("/workReport")
public class WorkReportController {

	@Autowired
	private WorkReportService wrs;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		List<Report> workReportList = wrs.getWorkReportListAll();

		model.addAttribute("workReportList", workReportList);

		return "workReport/list";
	}

	@RequestMapping(value = "read", method = RequestMethod.GET)
	public String read(Model model, @Param("idx") int idx) {

		List<ReportDetail> workReportDetailList = wrs.getWorkReportDetailList(idx);

		model.addAttribute("workReportDetailList", workReportDetailList);

		return "workReport/read";
	}

	@RequestMapping(value = "form", method = RequestMethod.GET)
	public String form() {

		return "workReport/form";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(
			Model model, HttpServletRequest request) {
		
		Enumeration<String> parameterNames = request.getParameterNames();
		request.getParameterMap();
		
//		model.addAttribute("result", result);

		return "workReport/update";
	}

}
