package com.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;

public class MessageDao {

	private static MessageDao messageDao = new MessageDao();

	public static MessageDao getInstance() {
		return messageDao;
	}

	private MessageDao() {
	}

	public int insert(Connection conn, Message message) throws SQLException {

		PreparedStatement pstmt = null;

		try {

			String sql = "INSERT INTO GUESTBOOK_MESSAGE (GUEST_NAME, PASSWORD, MESSAGE) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getGuestName());
			pstmt.setString(2, message.getPassword());
			pstmt.setString(3, message.getMessage());
			return pstmt.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public Message select(Connection conn, int messageId) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM GUESTBOOK_MESSAGE WHERE MESSAGE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, messageId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				return makeMessageFromResultSet(rs);
			} else {
				return null;
			}

		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
		Message message = new Message();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setPassword(rs.getString("password"));
		message.setMessage(rs.getString("message"));
		return message;
	}

	public int selectCount(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			String sql = "SELECT COUNT(*) FROM GUESTBOOK_MESSAGE";
			rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

	}

	public List<Message> selectList(Connection conn, int firstRow, int endRow) throws SQLException {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM GUESTBOOK_MESSAGE ORDER BY MESSAGE_ID DESC LIMIT ?, ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow - 1);
			pstmt.setInt(2, endRow - firstRow + 1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				List<Message> messageList = new ArrayList<Message>();
				do {
					messageList.add(makeMessageFromResultSet(rs));
				} while(rs.next());
				return messageList;
			} else {
				return Collections.emptyList();
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} 
	}
	
	public int delete(Connection conn, int messageId) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM GUESTBOOK_MESSAGE WHERE MESSAGE_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  messageId);
			return pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}