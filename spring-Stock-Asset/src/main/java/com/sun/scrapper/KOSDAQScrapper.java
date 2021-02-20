package com.sun.scrapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.model.Stock;

public class KOSDAQScrapper {
	
	public static ArrayList<Stock> getKOSDAQStocks() throws IOException {
		
		ArrayList<Stock> KOSDAQ30 = new ArrayList<Stock>();
		
		String url = "https://finance.naver.com/sise/sise_market_sum.nhn?sosok=1";
		
		Document doc = Jsoup.connect(url).get();
		
		Elements elements = doc.select("tbody a");
		
		int idx = 0;
		
		for(Element element : elements) {
			Stock stock = new Stock(element.html(), element.attr("href").substring(20), "kosdaq");
			if(idx % 2 == 0) {
				KOSDAQ30.add(stock);
			}
			idx++;
			if(idx >= 60) {
				break;
			}
		}
		
		return KOSDAQ30;
	}
	
	public static void scrapKOSDAQ(int page) throws SQLException, ClassNotFoundException, IOException {
		
		// elements 가져오기
		String queryUrl = "https://finance.naver.com/sise/sise_market_sum.nhn?sosok=1&page=" + page;
		Document doc = Jsoup.connect(queryUrl).get();
		Elements elements = doc.select(".type_2 tbody a");		
		
		// sql 전처리
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "stock";
		String pw = "stock";

		Connection conn = DriverManager.getConnection(url, id, pw);
		
		int idx = 0;
		for(Element element : elements) {
			String sql = "insert into stock values (?, ?, 'KOSDAQ')";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			if(idx % 2 == 0) {
				pstmt.setString(1, element.text());
				pstmt.setString(2, element.attr("href").substring(20));
				pstmt.executeUpdate();
				System.out.println("insert into stock values ( " + element.text() +", "+ element.attr("href").substring(20) + " )");
			}
			idx++;	
		}
	
	}

}
