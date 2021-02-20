package com.mtcm.sample.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mtcm.sample.service.vo.Report;
import com.mtcm.sample.service.vo.ReportDetail;

@Repository
public class CmmnDao {

	@Autowired
	private SqlSessionTemplate sst;

	public List<Report> getWorkReportListAll() {
		return sst.selectList("workreportns.getWorkReportListAll");
	}

	public List<ReportDetail> getWorkReportDetailList(int idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		return sst.selectList("workreportns.getWorkReportDetailList", map);
	}

}
