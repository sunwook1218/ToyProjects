<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<title>Hielo by TEMPLATED</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="${ctxPath }/assets/css/main.css" />
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>

<body class="subpage">

<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Sed amet nulla</p>
				<h2>게시글 목록</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">

		<!-- Elements -->
		<h2 id="elements">게시글 목록</h2>
		<hr />
		<!-- Table -->
		<div class="table-wrapper">
			<table>
				<thead>
					<tr>
						<th>게시글 번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="article" items="${articlePage.content}">
						<tr>
							<td>${article.number}</td>
							<td><a href="read.do?no=${article.number}">${article.title}</a></td>
							<td>${article.writer.name}</td>
							<td>${article.readCount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<nav aria-label="Page navigation example">
		<div style="display: flex; justify-content: center">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
    <c:forEach var="pNo" begin="${articlePage.startPage }" end="${articlePage.endPage }">
	<li class="page-item"><a class="page-link" href="${ctxPath }/portfolio/list.do?pageNo=${pNo }">${pNo }</a></li>
	</c:forEach>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
  </div>
</nav>
		<br />
		<div style="text-align: right;">
		<a href="${ctxPath }/portfolio/write.do" class="button special" >Write New</a>
		</div>
		<hr>
		<form action="${ctxPath}/search.do?code=${param.code}">
			<div class="row uniform">
				<div class="9u 12u$(small)">
					<input type="text" name="code" placeholder="Code" />
				</div>
				<div class="3u$ 12u$(small)">
					<input type="submit" value="Search" class="fit" />
				</div>
			</div>
		</form>


	</div>

	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
				<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
			</ul>
		</div>
		<div class="copyright">
			&copy; Untitled. All rights reserved.
		</div>
	</footer>

	<!-- Scripts -->
	<script src="${ctxPath }/assets/js/jquery.min.js"></script>
	<script src="${ctxPath }/assets/js/jquery.scrollex.min.js"></script>
	<script src="${ctxPath }/assets/js/skel.min.js"></script>
	<script src="${ctxPath }/assets/js/util.js"></script>
	<script src="${ctxPath }/assets/js/main.js"></script>

</body>

</html>