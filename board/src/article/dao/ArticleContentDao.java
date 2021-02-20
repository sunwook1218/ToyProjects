package article.dao;

import java.sql.*;

import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {

	public ArticleContent insert(Connection conn, ArticleContent content) throws SQLException {
		
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ARTICLE_CONTENT (ARTICLE_NO, CONTENT, FILE_NAME) VALUES (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			pstmt.setString(3, content.getFileName());
			int insertedCount = pstmt.executeUpdate();
			if(insertedCount > 0) {
				return content;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	/*
	 * 조회관련 DAO
	 */
	public ArticleContent selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ARTICLE_CONTENT WHERE ARTICLE_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ArticleContent content = null;
			if(rs.next()) {
				content = new ArticleContent(rs.getInt("article_no"), rs.getString("content"), rs.getString("file_name"));
			}
			
			return content;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	/*
	 * 게시글 수정 기능
	 */
	public int update(Connection conn, int no, String content) throws SQLException {
		String sql = "UPDATE ARTICLE_CONTENT SET CONTENT = ? WHERE ARTICLE_NO = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		} 
	}
	
	/*
	 * 게시글 삭제 기능
	 */
	public int delete(Connection conn, int no) throws SQLException {
		String sql = "DELETE FROM ARTICLE_CONTENT WHERE ARTICLE_NO = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, no);
			return pstmt.executeUpdate();
		}
	}
}
