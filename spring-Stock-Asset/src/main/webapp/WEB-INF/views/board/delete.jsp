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
location.href = "${path }/board/read?code=${param.code}&idx=${param.idx}";
</script>
</c:if>
<c:if test="${result == -1 }">
<script type="text/javascript">
alert("당신의 글이 아닙니다.");
location.href = "${path }/board/read?code=${param.code}&idx=${param.idx}";
</script>
</c:if>
</head>
<body>

</body>
</html>