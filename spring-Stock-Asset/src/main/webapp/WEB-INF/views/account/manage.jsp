<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Hielo by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="${path }/resources/css/main.css" />
</head>
<body class="subpage">

	<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Sed amet nulla</p>
				<h2>Account Manage</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">

		<!-- Elements -->
		<h2 id="elements">내 계좌</h2>
		<!-- Table -->
		<h4>Alternate</h4>
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>계좌번호</th>
						<th>Remark</th>
						<th>예수금</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="account" items="${accountList }">
						<tr>
							<td>${account.a_num }</td>
							<td>${account.remark }</td>
							<td>${account.balance }</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2"></td>
						<td>${depositSum }</td>
					</tr>
				</tfoot>
			</table>
		</div>
		
		<a href="${path }/account/createForm">새계좌 개설하기</a>


	</div>

	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-envelope-o"><span
						class="label">Email</span></a></li>
			</ul>
		</div>
		<div class="copyright">&copy; Untitled. All rights reserved.</div>
	</footer>

	<!-- Scripts -->
	<script src="${path }/resources/js/jquery.min.js"></script>
	<script src="${path }/resources/js/jquery.scrollex.min.js"></script>
	<script src="${path }/resources/js/skel.min.js"></script>
	<script src="${path }/resources/js/util.js"></script>
	<script src="${path }/resources/js/main.js"></script>

</body>
</html>