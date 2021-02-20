package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.DeleteArticleService;
import article.service.DeleteRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import auth.service.User;
import jdbc.mvc.controller.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {

	private static final String FAIL_VIEW = "/WEB-INF/view/failToDelete.jsp";

	private ReadArticleService readService = new ReadArticleService();
	private DeleteArticleService deleteService = new DeleteArticleService();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		try {
			String noVal = request.getParameter("no");
			int articleNum = Integer.parseInt(noVal);
			ArticleData articleData = readService.getArticle(articleNum, false);
			User authUser = (User) request.getSession().getAttribute("authUser");
			
			if(!canDelete(authUser, articleData)) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return null;
			}
			
			DeleteRequest delReq = new DeleteRequest(authUser.getId(), articleNum);
			request.setAttribute("delReq", delReq);
			
			Map<String, Boolean> errors = new HashMap<>();
			request.setAttribute("errors", errors);
			delReq.validate(errors);
			
			if(!errors.isEmpty()) {
				return FAIL_VIEW;
			}
			
			deleteService.delete(delReq);
			return "/WEB-INF/view/deleteSuccess.jsp";
			
		} catch(ArticleNotFoundException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}

	private boolean canDelete(User authUser, ArticleData articleData) {
		String writerId = articleData.getArticle().getWriter().getId();
		return authUser.getId().equals(writerId);
	}
}