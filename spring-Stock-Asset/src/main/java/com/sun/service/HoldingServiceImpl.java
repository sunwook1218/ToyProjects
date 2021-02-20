package com.sun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.HoldingsDao;
import com.sun.model.Holdings;
import com.sun.model.InvestData;

@Service
public class HoldingServiceImpl implements HoldingService {

	@Autowired
	private HoldingsDao hd;

	@Override
	public Holdings getHoldingByCode(InvestData investData) {
		return hd.getHoldingByCode(investData);
	}

	@Override
	public int insertNew(Holdings newHoldings) {
		return hd.insertNew(newHoldings);
	}

	@Override
	public int update(Holdings holdings) {
		return hd.update(holdings);
	}

	@Override
	public int delete(Holdings holdings) {
		return hd.delete(holdings);
	}

	@Override
	public List<Holdings> getListByM_idx(int m_idx) {
		return hd.getListByM_idx(m_idx);
	}

	@Override
	public void treat(int m_idx) {
		hd.treat(m_idx);
	}

}
