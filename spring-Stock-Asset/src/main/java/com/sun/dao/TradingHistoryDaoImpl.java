package com.sun.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.model.TradingHistory;

@Repository
public class TradingHistoryDaoImpl implements TradingHistoryDao {

	@Autowired
	private SqlSessionTemplate sst;

	@Override
	public int trading(TradingHistory th) {
		return sst.insert("tradingns.trading", th);
	}

	@Override
	public List<TradingHistory> getListByM_idx(int m_idx) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("m_idx", m_idx);
		return sst.selectList("tradingns.getListByM_idx", map);
	}


}
