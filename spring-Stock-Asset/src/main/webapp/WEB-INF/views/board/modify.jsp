<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify</title>
<c:if test="${result > 0 }">
<script type="text/javascript">

alert("성공적으로 수정되었습니다.");
location.href="${path}/board/list?code=${param.code }";

</script>
</c:if>
<c:if test="${result == 0 }">
<script type="text/javascript">

alert("수정에 실패하였습니다.");
location.href="${path}board/list?code=${param.code }";

</script>
</c:if>
</head>
<body>

</body>
</html>