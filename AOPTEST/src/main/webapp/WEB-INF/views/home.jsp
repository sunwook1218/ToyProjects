<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$(".option").click(function(){
				$("#textarea").load("${contextPath}/advice1.jsp", function(responseTxt, statusTxt, xhr) {
					if(statusTxt == "error")
						alert("Error: " + xhr.status + ": " + xhr.statusText);
				});
			});
			var kkeys = [], konami = "38,38,40,40,37,39,37,39,66,65";
    		$(document).keydown(function(e) {
        		kkeys.push(e.keyCode);
        		
        		if (kkeys.toString().indexOf(konami) >= 0) {
					kkeys = [];
					alert("");
					location.href="${contextPath }/konami.jsp";
				}
			});
		});
	</script>
	<style type="text/css">
	.container {
		padding: 40px;
	}
	</style>
</head>
<body>
	<div class="container">
	<form action="${contextPath }/crud/insert" method="post">
		option : 
			<input class="option" type="radio" name="option" value="1" checked="checked" />
			<input class="option" type="radio" name="option" value="2"/>
			<input class="option" type="radio" name="option" value="3"/>
			<input class="option" type="radio" name="option" value="4"/>
		<br />
		name1 : 
			<input class="input" type="text" name="name1" />
		age1 : 
			<input class="input" type="number" name="age1" />
		<br />
		name2 : 
			<input class="input" type="text" name="name2" />
		age2 : 
			<input class="input" type="number" name="age2" />
			
			<input type="submit" value="전송" />
	</form>
		
	<hr />

	<div>
		<p>advice</p>
		<textarea id="textarea" rows="30" cols="100" readonly="readonly"></textarea>
	</div>
	<hr />
	<div>
		현재 db상태 / <a href="${contextPath }/crud/delete"><button>테이블 전체삭제</button></a>
		<br />
		<!-- Table -->
		<table border="1">
			<thead>
				<tr>
				    <td>idx</td><td>name</td><td>age</td>
				</tr>
			</thead>
			<tbody>
		<c:if test="${empty allMemberList }">
			<tr>
				<td colspan="3">현재 저장된 member가 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty allMemberList }">
		<c:forEach  var="member" items="${allMemberList }" >
			<tr>
				<td>${member.idx }</td><td>${member.name }</td><td>${member.age }</td>
			</tr>	
		</c:forEach>
		</c:if>
			</tbody>
		</table>
	</div>
	</div>
</body>
</html>