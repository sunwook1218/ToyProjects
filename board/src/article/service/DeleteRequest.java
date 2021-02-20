package article.service;

import java.util.Map;

public class DeleteRequest {

	private String userId;
	private Integer articleNo;

	public DeleteRequest(String userId, Integer articleNo) {
		super();
		this.userId = userId;
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getArticleNo() {
		return articleNo;
	}

	public void validate(Map<String, Boolean> errors) {
		if (articleNo == null) {
			errors.put("no", Boolean.TRUE);
		}
	}

}
