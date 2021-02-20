package member.dao;

import java.sql.*;
import java.util.Date;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	
	public Member selectById(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			
			if(rs.next()) {
				String memberid = rs.getString("memberid");
				String name = rs.getString("name");
				String password = rs.getString("password");
				Date regDate = toDate(rs.getTimestamp("regdate"));
				member = new Member(memberid, name, password, regDate);
			}
			return member;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Connection conn, Member mem) throws SQLException {
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?)";
		try (PreparedStatement pstmt=
				conn.prepareStatement(sql)) {
			pstmt.setString(1, mem.getMemberid());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setTimestamp(4, new Timestamp(mem.getRegDate().getTime()));
			pstmt.executeUpdate();
		}
	}
	
	public void update(Connection conn, Member member) throws SQLException {
		String sql = "UPDATE MEMBER SET NAME = ?, PASSWORD = ? WHERE MEMBERID = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getMemberid());
			pstmt.executeUpdate();
		}
	}
}
