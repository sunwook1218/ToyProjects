package com.sun.scrapper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.model.Stock;

public class TestMain {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {

//		update30();

		// create table stock build
	}

	private static void update30() throws IOException, ClassNotFoundException {

		/**
		 * 30크기의 ArrayList 3가지
		 */
		ArrayList pop30 = PopularScrapper.getPopStocks();

		ArrayList kospi30 = KOSPIScrapper.getKOSPIStocks();

		ArrayList kosdaq30 = KOSDAQScrapper.getKOSDAQStocks();

		for (int i = 0; i < pop30.size(); i++) {
			Stock stock = (Stock) pop30.get(i);
			String code = stock.getCode();
			try {
				/*
				 * SQL 문을 실행하는 부분
				 */
				TableScrapper.process(code);
			} catch (SQLException e) {
				/*
				 * Exception이 나오면 흘려보내준다.
				 */
				e.printStackTrace();
			}
		}

		for (int i = 0; i < kospi30.size(); i++) {
			Stock stock = (Stock) kospi30.get(i);
			String code = stock.getCode();
			try {
				TableScrapper.process(code);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < kosdaq30.size(); i++) {
			Stock stock = (Stock) kosdaq30.get(i);
			String code = stock.getCode();
			try {
				TableScrapper.process(code);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}