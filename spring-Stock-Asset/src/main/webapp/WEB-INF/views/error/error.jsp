<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<c:if test="${empty result }">
<script type="text/javascript">
alert("잘못된 접근입니다.");
window.history.back();
</script>
</c:if>
<c:if test="${result == -101 }">
<script type="text/javascript">
alert("이미 사용하고 있는 아이디입니다.");
window.history.back();
</script>
</c:if>
<c:if test="${result == -102 }">
<script type="text/javascript">
alert("6자 이상의 비밀번호를 사용해주세요.");
window.history.back();
</script>
</c:if>
<c:if test="${result == -103 }">
<script type="text/javascript">
alert("성별을 선택해주세요.");
window.history.back();
</script>
</c:if>
<c:if test="${result == -301 }">
<script type="text/javascript">
alert("거래량을 정확히 입력해 주십시오");
window.history.back();
</script>
</c:if>
<c:if test="${result == -302 }">
<script type="text/javascript">
alert("거래량 오류: 주문내역을 다시 확인해주세요");
window.history.back();
</script>
</c:if>
<c:if test="${result == -401 }">
<script type="text/javascript">
alert("보유량보다 많은 매도를 할 수 없습니다.");
window.history.back();
</script>
</c:if>
<c:if test="${result == -402 }">
<script type="text/javascript">
alert("예수금이 부족합니다.");
window.history.back();
</script>
</c:if>
<c:if test="${result == -6 }">
<script type="text/javascript">
</script>
</c:if>
<c:if test="${result == -7 }">
<script type="text/javascript">
</script>
</c:if>
<c:if test="${result == -8 }">
<script type="text/javascript">
</script>
</c:if>
<c:if test="${result == -9 }">
<script type="text/javascript">
</script>
</c:if>
</head>
<body>
</body>
</html>