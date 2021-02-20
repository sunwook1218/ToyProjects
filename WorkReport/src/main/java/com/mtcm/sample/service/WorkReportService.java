package com.mtcm.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtcm.sample.dao.CmmnDao;
import com.mtcm.sample.service.vo.Report;
import com.mtcm.sample.service.vo.ReportDetail;

@Service
public class WorkReportService {

	@Autowired
	private CmmnDao dao;

	public List<Report> getWorkReportListAll() {
		return dao.getWorkReportListAll();
	}

	public List<ReportDetail> getWorkReportDetailList(int idx) {
		return dao.getWorkReportDetailList(idx);
	}

	public int update(String title, String content, String tags) {

		if (tags == null) {

		}

		String[] tagArray = trearment(tags);

		int concode = createNewTagContainer();

		return 0;
	}

	private int createNewTagContainer() {

		return 0;
	}

	private String[] trearment(String tags) {

		if (tags == null) {
			return null;
		}

		String[] tagArray = tags.split("#");

		for (int i = 0; i < tagArray.length; i++) {
//			tagArray[i].trim();
			tagArray[i].replace(" ", "");
			tagArray[i].replace(",", "");
		}

		return tagArray;
	}

}
