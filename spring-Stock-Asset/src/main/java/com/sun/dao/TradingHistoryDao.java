package com.sun.dao;

import java.util.List;

import com.sun.model.TradingHistory;

public interface TradingHistoryDao {

	int trading(TradingHistory th);

	List<TradingHistory> getListByM_idx(int m_idx);

}
