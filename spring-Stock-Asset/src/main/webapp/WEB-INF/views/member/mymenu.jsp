<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>
<!--
	Hielo by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>

<head>
	<title>MyMenu</title>
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
				<h2>MY MENU</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">

		<h2 id="elements">회원 정보</h2>
		<!-- table -->

		<div class="table-wrapper">
			<table class="alt">
				<tbody>
					<tr>
						<td>아이디</td>
						<td>${authUser.id }</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>${authUser.name }</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td>${authUser.password }</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${authUser.email }</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>${authUser.address }</td>
					</tr>
				</tbody>
			</table>
		</div>

		<hr />

		<!-- Lists -->
		<h3>내 게시글</h3>
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>글넘버</th>
						<th>종목</th>
						<th>제목</th>
						<th>작성일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${boardList }">
						<tr>
							<td>${board.idx }</td>
							<td>${board.s_code }</td>
							<td><a href="${path }/board/read?code=${board.s_code }&idx=${board.idx}">${board.title }</a></td>
							<td>${board.reg_date }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<h3>계좌현황</h3>
		<!-- Table -->
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
		<hr>
		<h3>보유종목</h3>
				<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>종목명</th>
						<th>수량</th>
						<th>매입가</th>
						<th>총매입가</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="holdings" items="${holdingsList }">
						<tr>
							<td><a href="${path }/stock/detail?code=${holdings.s_code }">${holdings.s_name }</a></td>
							<td>${holdings.amount }</td>
							<td>${holdings.p_price }</td>
							<td>${holdings.amount * holdings.p_price }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		<h3>거래내역</h3>
				<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>체결날짜</th>
						<th>종목명</th>
						<th>수량</th>
						<th>체결가</th>
						<th>매매</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="tradingHistory" items="${tradingHistoryList }">
						<tr>
							<td>${tradingHistory.t_date }</td>
							<td><a href="${path }/stock/detail?code=${tradingHistory.s_code }">${tradingHistory.s_name }</a></td>
							<td>${tradingHistory.amount }</td>
							<td>${tradingHistory.price }</td>
							<td>${tradingHistory.action }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
	</div>

	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<ul class="icons">
				<li><a href="" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
				<li><a href="" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
			</ul>
		</div>
		<div class="copyright">
			&copy; Untitled. All rights reserved.
		</div>
	</footer>

	<!-- Scripts -->
	<script src="${path }/resources/js/jquery.min.js"></script>
	<script src="${path }/resources/js/jquery.scrollex.min.js"></script>
	<script src="${path }/resources/js/skel.min.js"></script>
	<script src="${path }/resources/js/util.js"></script>
	<script src="${path }/resources/js/main.js"></script>

</body>

</html>