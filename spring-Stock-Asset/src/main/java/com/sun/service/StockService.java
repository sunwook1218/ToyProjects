package com.sun.service;

import java.util.List;

import com.sun.model.Quotation;
import com.sun.model.Stock;

public interface StockService {

	List<Quotation> getQuotationList(String code);

	List<Stock> getStockList(String query);

	String getStockName(String code);

	List<Stock> getList(Stock forSearch);

	int getTotal(String query);

}
