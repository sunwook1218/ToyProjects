package com.sun.service;

import java.util.List;

import com.sun.model.TradingHistory;

public interface TradingHistoryService {

	int trading(TradingHistory th);

	List<TradingHistory> getListByM_idx(int idx);

}
