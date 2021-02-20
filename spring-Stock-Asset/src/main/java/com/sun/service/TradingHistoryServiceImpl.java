package com.sun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.TradingHistoryDao;
import com.sun.model.TradingHistory;

@Service
public class TradingHistoryServiceImpl implements TradingHistoryService {

	@Autowired
	private TradingHistoryDao thd;

	@Override
	public int trading(TradingHistory th) {
		return thd.trading(th);
	}

	@Override
	public List<TradingHistory> getListByM_idx(int m_idx) {
		return thd.getListByM_idx(m_idx);
	}

}
