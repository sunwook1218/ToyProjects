<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript">

	function testfunc() {
		<%
		System.out.println("123312");
		%>
	}
	
	setInterval(testfunc, 1000);
	
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<div> 
<a href="<%=request.getContextPath()%>/workReport/list">workReport로 이동하기</a>
</div>
</body>
</html>
