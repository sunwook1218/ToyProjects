<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<% session.setAttribute("contextPath", application.getContextPath()); %>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
	location.href = "${contextPath}/view/home";
	</script>
</head>
<body>
</body>
</html>