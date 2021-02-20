<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	let i = 0;
	$("#add").click(function name() {
		// alert("add btn");
		i++;
		$("#form-container").append("<input name=\"name" + i +"\">");
	});
});
</script>
</head>
<body>
	form 페이지
	<form action="<%=request.getContextPath()%>/workReport/update" method="post">
		<div id="form-container">
			제목 : <input name="title" type="text" />
			<br />
			내용  : <textarea name="content" rows="5" cols="30"></textarea>
			<br />
			tags : <input name="tags" type="text" />
			<br />
			<input type="submit" value="작성" />
		</div>
	</form>
	<button id="add">add btn</button>
</body>
</html>
