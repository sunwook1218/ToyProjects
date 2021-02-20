package com.guest.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guest.dao.MessageDao;
import com.guest.jdbc.JdbcUtil;
import com.guest.model.Message;

/**
 * Servlet implementation class MessageDaoInsertTestServlet
 */
@WebServlet("/MessageDaoInsertTestServlet")
public class MessageDaoInsertTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageDaoInsertTestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:guestbook");
			Message message = new Message();
			message.setGuestName("홍길동2");
			message.setPassword("hong");
			message.setMessage("홍길동 다녀감2");

			MessageDao dao = MessageDao.getInstance();
			dao.insert(conn, message);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
