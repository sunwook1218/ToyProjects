<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="${contextPath }/corona19/dashboard">
	start : <input type="date" name="startDate" /> <br />
	end : <input type="date" name="endDate" />
	<input type="submit" value="submit" />
</form>
<hr />
<ol>
<c:forEach var="item" items="${itemList }">
	<li>
		<ol>
			<li>seq : ${item.seq }</li>
			<li>기준일 : ${item.stateDt }</li>
			<li>기준 시간 : ${item.stateTime }</li>
			<li>누적 환진률  : ${item.accDefRate }</li>
			<li>누적 검사 수  : ${item.accExamCnt }</li>
			<li>누적 검사 완료 수  : ${item.accExamCompCnt }</li>
			<li>확진자 수  : ${item.decideCnt }</li>
			<li>격리해제 수 : ${item.clearCnt }</li>
			<li>검사진행 수 : ${item.examCnt }</li>
			<li>사망자 수  : ${item.deathCnt }</li>
			<li>치료중 환자 수  : ${item.careCnt }</li>
			<li>결과 음성 수  : ${item.resutlNegCnt }</li>
			<li>등록 일시분초 : ${item.createDt }</li>
			<li>수정 일시분초 : ${item.updateDt }</li>
		</ol>
	</li>
	<br />
</c:forEach>
</ol>
</body>
</html>