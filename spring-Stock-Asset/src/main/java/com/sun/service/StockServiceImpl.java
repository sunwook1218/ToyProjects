package com.sun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.dao.QuotationDao;
import com.sun.dao.StockDao;
import com.sun.model.Quotation;
import com.sun.model.Stock;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private QuotationDao qd;

	@Autowired
	private StockDao sd;

	@Override
	public List<Quotation> getQuotationList(String code) {
		return qd.getQuotationList(code);
	}

	@Override
	public List<Stock> getStockList(String query) {
		if (canQueryParseInt(query)) {
			return sd.getStockListFromCode(query);
		} else {
			return sd.getStockListFromName(query);
		}
	}

	@Override
	public String getStockName(String code) {
		return sd.getStockName(code);
	}

	@Override
	public List<Stock> getList(Stock forSearch) {
		if (canQueryParseInt(forSearch.getSearch())) {
			return sd.getListByCode(forSearch);
		} else {
			return sd.getListByName(forSearch);
		}
	}

	@Override
	public int getTotal(String query) {
		if (canQueryParseInt(query)) {
			return sd.getTotalByCode(query);
		} else {
			return sd.getTotalByName(query);
		}

	}

	private boolean canQueryParseInt(String query) {
		try {
			Integer.parseInt(query);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
