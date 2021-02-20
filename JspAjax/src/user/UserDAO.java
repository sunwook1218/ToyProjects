package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {

	private static UserDAO instance;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbID = "c##ajax";
			String dbPassword = "ajax";
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
		}
		return instance;
	}

	public ArrayList<User> search(String userName) throws SQLException {

		ArrayList<User> userList = new ArrayList<User>();

		String sql = "SELECT * FROM USER_ WHERE userName LIKE '%" + userName + "%'";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("UserDAO" + rs.next());
			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("USERNAME"));
				user.setUserAge(rs.getInt("USERAGE"));
				user.setUserGender(rs.getString("USERGENDER"));
				user.setUserEmail(rs.getString("USEREMAIL"));
				userList.add(user);
				System.out.println(user.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userList;
	}

	public int register(User user) {
		String sql = "INSERT INTO USER VALUES (?, ?, ?, ?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setInt(2, user.getUserAge());
			pstmt.setString(3, user.getUserGender());
			pstmt.setString(4, user.getUserEmail());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
