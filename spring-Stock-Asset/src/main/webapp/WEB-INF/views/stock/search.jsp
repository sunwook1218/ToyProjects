<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<html>

<head>
<title>Search</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="${path }/resources/css/main.css" />
</head>

<body class="subpage">

	<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Sed amet nulla</p>
				<h2>Stock</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">
		<!-- Search Bar -->
		<form action="search?code=${param.code }">
			<div class="row uniform">
				<div class="9u 12u$(small)">
					<input type="text" name="query" placeholder="검색" />
				</div>
				<div class="3u$ 12u$(small)">
					<input type="submit" value="Search" class="fit" />
				</div>
			</div>
		</form>

		<!-- Lists -->
		<h3>검색 결과</h3>
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<th>MARKET</th>
						<th>상품명</th>
						<th>CODE</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty stockList }">
						<td colspan="3">검색 결과가 없습니다.</td>
					</c:if>
					<c:forEach var="stock" items="${stockList }">
						<tr>
							<td>${stock.market }</td>
							<td><a href="${path }/stock/detail?code=${stock.code}">${stock.name }</a></td>
							<td>${stock.code }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div style="text-align: center;">
				<nav aria-label="Page navigation example" >
					<ul class="pagination justify-content-center" >
						<c:if test="${pb.startPage > pb.pagePerBlock}">
							<li class="page-item"><a class="page-link" href="${path }/stock/search?query=${param.query }&page=${pb.startPage-1}" tabindex="-1">Previous</a></li>
						</c:if>
						<c:forEach var="i" begin="${pb.startPage}" end="${pb.endPage}">
							<c:if test="${i==pb.currentPage}">
								<li class="active"><a href="${path }/stock/search?query=${param.query }&page=${i}">${i}</a></li>
							</c:if>		
							<c:if test="${i!=pb.currentPage}">
								<li><a href="${path }/stock/search?query=${param.query }&page=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${pb.endPage < pb.totalPage }">
							<li class="page-item"><a class="page-link" href="${path }/stock/search?query=${param.query }&page=${pb.endPage+1}">Next</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
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