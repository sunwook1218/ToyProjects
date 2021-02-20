package com.sun.scrapper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TableScrapper {

	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	public static void process60(String code) throws ClassNotFoundException, SQLException, IOException {

		String tableName = "NO" + code;

		boolean tableExist = isTableExist(tableName);

		if (tableExist) {
			tableScrapping(code, 60);
		} else {
			createTable(code);
			tableScrapping(code, 60);
		}

	}

	public static void process(String code) throws ClassNotFoundException, SQLException, IOException {

		String tableName = "NO" + code;

		boolean tableExist = isTableExist(tableName);

		if (tableExist) {
			tableScrapping(code);
		} else {
			createTable(code);
			tableScrapping(code);
		}

	}

	private static void tableScrapping(String code) throws ClassNotFoundException, SQLException, IOException {

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "stock";
		String pw = "stock";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, id, pw);

		stmt = con.createStatement();

		int data_idx = 1;
		String lastPageStr = "";
		ArrayList<String> row = null;

		// 1. 검색을 원하는 stock의 code를 입력합니다.
		String stockCode = code;

		// 2. 해당 code의 stock의 lastPage를 구합니다.
		String initURL = "https://finance.naver.com/item/sise_day.nhn?code=" + stockCode;
		Document initDoc = Jsoup.connect(initURL).get();
		Elements lastPageContainer = initDoc.select(".pgRR");
		for (Element ele : lastPageContainer) {
			String[] lastPageArray = ele.html().split("page=");
			String[] lastPageArray2 = lastPageArray[1].split("\"");
			lastPageStr = lastPageArray2[0];
		}
		int lastPage = 1;
		if (lastPageStr.equals("")) {
			lastPage = 1;
		} else {
			lastPage = Integer.parseInt(lastPageStr);
		}

		// 3. Data Crawling & Pretreatment
		for (int page = 1; page <= lastPage; page++) {
			String URL = "https://finance.naver.com/item/sise_day.nhn?code=" + stockCode + "&page=" + page;

			Document doc = Jsoup.connect(URL).get();

			Elements Data = doc.select(".tah");

			for (Element datum : Data) {
				// 4. 7idx를 한 묶음으로 row에 저장하여, idx가 7의 배수일 때 DB에 한 row단위로 저장합니다.
				if (data_idx % 7 == 1) {
					// 7의 배수시 row의 초기화
					row = new ArrayList();
				}

				row.add(removeComma(datum.text()));

				if (data_idx % 7 == 0) {
					int result = stmt.executeUpdate(makeSQL(stockCode, row));
					System.out.println(makeSQL(stockCode, row) + ", " + result);
				}
				data_idx += 1;
			}
		}
	}

	private static void tableScrapping(String code, int rownum)
			throws ClassNotFoundException, SQLException, IOException {

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "stock";
		String pw = "stock";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, id, pw);

		stmt = con.createStatement();

		int data_idx = 1;
		String lastPageStr = "";
		ArrayList<String> row = null;

		// 1. 검색을 원하는 stock의 code를 입력합니다.
		String stockCode = code;

		// 2. 해당 code의 stock의 lastPage를 구합니다.
		String initURL = "https://finance.naver.com/item/sise_day.nhn?code=" + stockCode;
		Document initDoc = Jsoup.connect(initURL).get();
		Elements lastPageContainer = initDoc.select(".pgRR");
		for (Element ele : lastPageContainer) {
			String[] lastPageArray = ele.html().split("page=");
			String[] lastPageArray2 = lastPageArray[1].split("\"");
			lastPageStr = lastPageArray2[0];
		}
		int lastPage = 1;
		if (lastPageStr.equals("")) {
			lastPage = 1;
		} else {
			lastPage = Integer.parseInt(lastPageStr);
		}

		// 3. Data Crawling & Pretreatment
		if (lastPage >= 6) {
			for (int page = 1; page <= 6; page++) {
				String URL = "https://finance.naver.com/item/sise_day.nhn?code=" + stockCode + "&page=" + page;

				Document doc = Jsoup.connect(URL).get();

				Elements Data = doc.select(".tah");

				for (Element datum : Data) {
					// 4. 7idx를 한 묶음으로 row에 저장하여, idx가 7의 배수일 때 DB에 한 row단위로 저장합니다.
					if (data_idx % 7 == 1) {
						// 7의 배수시 row의 초기화
						row = new ArrayList();
					}

					row.add(removeComma(datum.text()));

					if (data_idx % 7 == 0) {
						int result = stmt.executeUpdate(makeSQL(stockCode, row));
						System.out.println(makeSQL(stockCode, row) + ", " + result);
					}
					data_idx += 1;
				}
			}
		} else {
			for (int page = 1; page <= lastPage; page++) {
				String URL = "https://finance.naver.com/item/sise_day.nhn?code=" + stockCode + "&page=" + page;

				Document doc = Jsoup.connect(URL).get();

				Elements Data = doc.select(".tah");

				for (Element datum : Data) {
					// 4. 7idx를 한 묶음으로 row에 저장하여, idx가 7의 배수일 때 DB에 한 row단위로 저장합니다.
					if (data_idx % 7 == 1) {
						// 7의 배수시 row의 초기화
						row = new ArrayList();
					}

					row.add(removeComma(datum.text()));

					if (data_idx % 7 == 0) {
						int result = stmt.executeUpdate(makeSQL(stockCode, row));
						System.out.println(makeSQL(stockCode, row) + ", " + result);
					}
					data_idx += 1;
				}
			}
		}

	}

	private static String removeComma(String data) {
		return data.replaceAll("\\,", "");
	}

	private static String makeSQL(String stockCode, ArrayList row) {
		String sql = "insert into no" + stockCode + " values ('" + row.get(0) + "', " + row.get(1) + ", " + row.get(2)
				+ ", " + row.get(3) + ", " + row.get(4) + ", " + row.get(5) + ", " + row.get(6) + ")";
		return sql;
	}

	private static void createTable(String code) throws ClassNotFoundException, SQLException {

		String sql = "create table no" + code + " " + "( " + "rec_date date primary key, " + "cq number, "
				+ "var number, " + "oq number, " + "hq number, " + "lq number, " + "tv number " + ")";

		System.out.println(sql);

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "stock";
		String pw = "stock";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, id, pw);

		stmt = con.createStatement();

		stmt.executeUpdate(sql);

	}

	private static boolean isTableExist(String tableName) throws ClassNotFoundException, SQLException {

		String upperTableName = tableName.toUpperCase();

		String sql = "SELECT COUNT(*) cnt FROM ALL_TABLES WHERE TABLE_NAME = '" + upperTableName + "'";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "stock";
		String pw = "stock";

		con = DriverManager.getConnection(url, id, pw);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);

		if (rs.next()) {
			if (rs.getInt("CNT") == 1) {
				return true;
			} else if (rs.getInt("CNT") == 0) {
				return false;
			}
		}

		return false;
	}
}