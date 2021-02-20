<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ctxPath }/assets/css/main.css" />
</head>

<body class="subpage">

	<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Sed amet nulla</p>
				<h2>Portfolio</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">
		<form method="post" action="${ctxPath }/search.do?no=${param.code}">
			<div class="row uniform">
				<div class="9u 12u$(small)">
					<input type="text" name="code" placeholder="Code" />
				</div>
				<div class="3u$ 12u$(small)">
					<input type="submit" value="Search" class="fit" />
				</div>
			</div>
		</form>
		<hr />
		<h2>${articleData.article.title }</h2>

		<!-- Box -->
		<h1>${articleData.article.writer.name } / ${articleData.article.regDate }</h1>
		<hr />
		<div class="box">
			<h3>고객님의 투자처</h3>
			<a href="${ctxPath }/search.do?code=${articleData.port.inv_where }">
				<p>${articleData.port.inv_where }</p>
			</a>
			<h3>고객님의 투자 금액</h3>
			<p><fmt:formatNumber    value="${articleData.port.inv_howMuch }"   maxFractionDigits="3"/> 원</p>
			<h3>고객님의 현재 자산 가치</h3>
			<p><fmt:formatNumber    value="${articleData.port.inv_howMuch * per }"   maxFractionDigits="3"/> 원 / 자산가치 ${per } 배</p>
			<h3>기록 내용</h3>
			<span class="image fit">
			<img src="<%=request.getContextPath() %>/images/portfolio/${articleData.article.number }/${articleData.fileName}" alt="" />
			</span>
			<p style="white-space: pre-wrap;">
<c:out value="${articleData.content }"/>
			</p>

		</div>
		<ul class="actions">
			<li><a href="${ctxPath }/portfolio/modify.do?no=${param.no}" class="button alt">수정</a></li>
			<li><a class="button special" data-toggle="modal" data-target="#exampleModalCenter">삭제</a></li>
		</ul>

		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">포트폴리오 삭제</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						정말로 포트폴리오를 삭제하시겠습니까?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
						<a href="${ctxPath }/portfolio/delete.do?no=${param.no}" class="button special">삭제</a>
					</div>
				</div>
			</div>
		</div>
		<hr />

		<h3>댓글</h3>
		
			<div class="table-wrapper ">
				<table>
					<tbody>
						<c:forEach var="comment" items="${commentList }">
						<tr>
							<td>${comment.writerName }</td>
							<td>${comment.content }</td>
							<td>${comment.regDate }</td>
							<td><a href="${ctxPath }/portfolio/comment/delete.do?comment_no=${comment.commentNumber}&article_no=${param.no}" class="button alt">삭제</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		<br />
		<br />
		<form method="post" action="${ctxPath }/portfolio/read.do?no=${param.no}">
			<div class="row uniform">
				<div class="10u 12u$(small)">
					<input type="text" name="new_comment" placeholder="Comment" />
				</div>
				<div class="2u$ 12u$(small)">
					<input type="submit" value="등록" class="fit" />
				</div>
			</div>
		</form>

		<hr />

		<!-- articleList -->
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
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
	<script src="${ctxPath }/assets/js/jquery.min.js"></script>
	<script src="${ctxPath }/assets/js/jquery.scrollex.min.js"></script>
	<script src="${ctxPath }/assets/js/skel.min.js"></script>
	<script src="${ctxPath }/assets/js/util.js"></script>
	<script src="${ctxPath }/assets/js/main.js"></script>

</body>

</html>