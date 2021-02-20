package com.mtcm.util.autoDate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class Main {

	private static Connection conn;
	private static PreparedStatement pstmt;

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String id = "c##workreport";
	private static String pw = "workreport";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		run();

	}

	private static String getDate(String baseDate, int iDay) {

		Calendar temp = Calendar.getInstance();

		temp.set(Calendar.YEAR, Integer.parseInt(baseDate.substring(0, 4)));
		temp.set(Calendar.MONTH, Integer.parseInt(baseDate.substring(4, 6)) - 1);
		temp.set(Calendar.DATE, Integer.parseInt(baseDate.substring(6, 8)));

		temp.add(Calendar.DAY_OF_MONTH, iDay);

		int nYear = temp.get(Calendar.YEAR);
		int nMonth = temp.get(Calendar.MONTH) + 1;
		int nDay = temp.get(Calendar.DAY_OF_MONTH);

		StringBuffer sbDate = new StringBuffer();
		sbDate.append(nYear);

		if (nMonth < 10) {
			sbDate.append("0");
		}
		sbDate.append(nMonth);
		if (nDay < 10) {
			sbDate.append("0");
		}
		sbDate.append(nDay);

		return sbDate.toString();
	}

	private static String getWeekDataBasedFriday(String baseDate) {

		String year = baseDate.substring(2, 4);
		String month = baseDate.substring(4, 6);
		String day = baseDate.substring(6, 8);
		Integer weekInt = ((Integer.parseInt(day) - 1) / 7) + 1;
		String week = weekInt.toString();

		StringBuffer sb = new StringBuffer();

		sb.append(year);
		sb.append("/");
		sb.append(month);
		sb.append("/");
		sb.append(week);

		return sb.toString();

	}

	private static Connection getConnection(String driver, String url, String id, String pw)
			throws ClassNotFoundException, SQLException {

		Class.forName(driver);

		conn = DriverManager.getConnection(url, id, pw);

		return conn;
	}

	private static void process(Connection conn) throws SQLException {

		String sql = "INSERT INTO WDT_WEEK_DATA_TB VALUES (?, ?, ?)";

		pstmt = conn.prepareStatement(sql);

		String baseStartDateStr = "20200105";
		String baseFridayDateStr = "20200110";
		String baseEndDateStr = "20200111";

		for (int i = 0; i < 520; i++) {

			pstmt.setString(1, getWeekDataBasedFriday(baseFridayDateStr));
			pstmt.setString(2, baseStartDateStr);
			pstmt.setString(3, baseEndDateStr);

			int result = pstmt.executeUpdate();

			System.out.println(result);

			baseStartDateStr = getDate(baseStartDateStr, 7);
			baseFridayDateStr = getDate(baseFridayDateStr, 7);
			baseEndDateStr = getDate(baseEndDateStr, 7);

		}

	}

	private static void run() throws ClassNotFoundException, SQLException {

		conn = getConnection(driver, url, id, pw);

		process(conn);

		conn.close();
	}

}
