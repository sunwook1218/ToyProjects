package com.sun.dao;

import java.util.List;

import com.sun.model.Stock;

public interface StockDao {

	List<Stock> getStockListFromCode(String query);

	List<Stock> getStockListFromName(String query);

	String getStockName(String code);

	List<Stock> getListByCode(Stock forSearch);

	List<Stock> getListByName(Stock forSearch);

	int getTotalByCode(String query);

	int getTotalByName(String query);

}
