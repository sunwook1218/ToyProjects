package com.sun.service;

import java.util.List;

import com.sun.model.Holdings;
import com.sun.model.InvestData;

public interface HoldingService {
	
	Holdings getHoldingByCode(InvestData investData);

	int insertNew(Holdings newHoldings);

	int update(Holdings holdings);

	int delete(Holdings holdings);

	List<Holdings> getListByM_idx(int idx);

	void treat(int m_idx);

}
