<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제시어</title>
<style type="text/css">
	.suggest {
		display: none;
		position: absolute;
		left: 11px;
		top: 131px;
	}
</style>
<script type="text/javascript">
	function sendKeyWord(){
		var userKeyword = document.myForm.userKeyword.value;
		if(userKeyword === "") {
			hide();
			return;
		}
	} 	
</script>
</head>
<body>

</body>
</html>