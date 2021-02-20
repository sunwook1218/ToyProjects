package com.sun.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.model.Stock;

@Repository
public class StockDaoImpl implements StockDao {

	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public List<Stock> getStockListFromCode(String query) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("query", query);
		return sst.selectList("stockns.getStockListByCode", map);
	}

	@Override
	public List<Stock> getStockListFromName(String query) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("query", query);
		return sst.selectList("stockns.getStockListByName", map);
	}

	@Override
	public String getStockName(String code) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		return sst.selectOne("stockns.getStockName", map);
	}

	@Override
	public List<Stock> getListByCode(Stock forSearch) {
		return sst.selectList("stockns.getListByCode", forSearch);
	}

	@Override
	public List<Stock> getListByName(Stock forSearch) {
		return sst.selectList("stockns.getListByName", forSearch);
	}

	@Override
	public int getTotalByCode(String query) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("query", query);
		return sst.selectOne("stockns.getTotalByCode", map);
	}

	@Override
	public int getTotalByName(String query) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("query", query);
		return sst.selectOne("stockns.getTotalByName", map);
	}

}
