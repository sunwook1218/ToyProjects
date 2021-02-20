package com.sun.util;

import java.io.IOException;
import java.sql.SQLException;

import com.sun.scrapper.KOSDAQScrapper;
import com.sun.scrapper.KOSPIScrapper;

public class PrjBulid {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		createTableStock();

	}

	private static void createTableStock() throws ClassNotFoundException, SQLException, IOException {

		for (int i = 1; i <= 29; i++) {
			KOSDAQScrapper.scrapKOSDAQ(i);
		}

		for (int i = 1; i <= 32; i++) {
			KOSPIScrapper.scrapKOSPI(i);

		}
	}

}
