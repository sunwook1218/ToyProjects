<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<html>
<head>
<script type="text/javascript">
    var kkeys = [], konami = "38,38,40,40,37,39,37,39,66,65";
    $(document).keydown(function(e) {
        kkeys.push(e.keyCode);
        if (kkeys.toString().indexOf(konami) >= 0) {
            kkeys = [];
            alert("master menu로 이동합니다");
            location.href="/member/master";
        }
    });
</script>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<c:forEach var="list" items="${kospi60list }">
		${list }
	</c:forEach>
	<c:forEach var="list" items="${kosdaq60list }">
		${list }
	</c:forEach>
</body>
</html>
