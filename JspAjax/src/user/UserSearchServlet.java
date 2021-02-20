package user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserSearchServlet")
public class UserSearchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userName = request.getParameter("userName");
		try {
			response.getWriter().write(getJSON(userName));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getJSON(String userName) throws SQLException {
		if (userName == null) {
			userName = "";
		}
		userName = userName.trim();
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		UserDAO userDAO = UserDAO.getInstance();
		ArrayList<User> userList = userDAO.search(userName);
		System.out.println("Servlet : " + userName);
		System.out.println("Servlet : " + userList.toString());
		for (int i = 0; i < userList.size(); i++) {
			result.append("[{\"value\" : \"" + userList.get(i).getUserName() + "\"},");
			result.append("{\"value\" : \"" + userList.get(i).getUserAge() + "\"},");
			result.append("{\"value\" : \"" + userList.get(i).getUserGender() + "\"},");
			result.append("{\"value\" : \"" + userList.get(i).getUserEmail() + "\"}],");
		}
		result.append("]}");
		
		System.out.println("Servlet : " + result.toString());

		return result.toString();
	}

}
