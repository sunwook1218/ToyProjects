package com.sun.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.model.Holdings;
import com.sun.model.InvestData;

@Repository
public class HoldingsDaoImpl implements HoldingsDao {

	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public Holdings getHoldingByCode(InvestData investData) {
		return sst.selectOne("holdingsns.getHoldingByCode", investData);
	}

	@Override
	public int insertNew(Holdings newHoldings) {
		return sst.insert("holdingsns.insertNew", newHoldings);
	}

	@Override
	public int update(Holdings holdings) {
		return sst.update("holdingsns.update", holdings);
	}

	@Override
	public int delete(Holdings holdings) {
		return sst.delete("holdingsns.delete", holdings);
	}

	@Override
	public List<Holdings> getListByM_idx(int m_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("m_idx", m_idx);
		return sst.selectList("holdingsns.getListByM_idx", map);
	}

	@Override
	public void treat(int m_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("m_idx", m_idx);
		sst.delete("holdingsns.treat", map);
	}

}

