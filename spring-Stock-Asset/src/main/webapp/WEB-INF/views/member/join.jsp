<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:if test="${result > 0 }">
<script type="text/javascript">
	alert("가입에 성공하였습니다.");
	location.href="${path }/index.jsp";
</script>
</c:if>
<c:if test="${result == 0 }">
<script type="text/javascript">
	alert("가입에 실패하였습니다. Home으로 돌아갑니다.");
	location.href="${path }/index.jsp";
</script>
</c:if>
</head>
<body>
</body>
</html>