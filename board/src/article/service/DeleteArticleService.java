package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteArticleService {
	
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	public void delete(DeleteRequest delReq) {
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Article article = articleDao.selectById(conn, delReq.getArticleNo());
			
			if(article == null) {
				throw new ArticleNotFoundException();
			}
			if(!canDelete(delReq.getUserId(), article)) {
				throw new PermissionDeniedException();
			}
			
			articleDao.delete(conn, delReq.getArticleNo());
			contentDao.delete(conn, delReq.getArticleNo());
			conn.commit();
			
		} catch(SQLException e)  {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.close(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean canDelete(String deletingUserId, Article article) {
		return article.getWriter().getId().equals(deletingUserId);
	}

}
