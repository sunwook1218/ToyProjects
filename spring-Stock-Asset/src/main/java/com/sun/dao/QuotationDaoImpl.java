package com.sun.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.model.Quotation;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class QuotationDaoImpl implements QuotationDao {

	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<Quotation> getQuotationList(String code) {
		code = "NO" + code;
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		List<Quotation> list = null;
		try {
			list = sst.selectList("quotationns.getQuotationList", map);
		} catch (Exception e) {
			log.info("---> 테이블이 존재하지 않습니다.");
		}

		return list;
	}

}
