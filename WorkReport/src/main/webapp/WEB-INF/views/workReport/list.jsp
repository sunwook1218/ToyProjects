<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#workreporttable {

border: 1px;

}
</style>
</head>
<body>
	리스트페이지
	<table id="workreporttable">
	<c:if test="${empty workReportList }">
	<tr>
	<td colspan="4">데이터가 없습니다.</td>
	</tr>
	</c:if>
	<c:if test="${not empty workReportList }">
		<thead>
			<tr>
				<td>글번호</td>
				<td>멤버아이디</td>
				<td>제목</td>
				<td>작성일자</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="workReport" items="${workReportList }">
		<tr>
		<td>${workReport.idx }</td>
		<td><a href="<%=request.getContextPath()%>/workReport/read?idx=${workReport.idx}">${workReport.m_id }</a></td>
		<td><a href="<%=request.getContextPath()%>/workReport/read?idx=${workReport.idx}">${workReport.title }</a></td>
		<td><a href="<%=request.getContextPath()%>/workReport/read?idx=${workReport.idx}">${workReport.regdate }</a></td>
		</tr>
		</c:forEach>
		</tbody>
	</c:if>
	</table>
	<a href="<%=request.getContextPath()%>/workReport/form">작성</a>
</body>
</html>
