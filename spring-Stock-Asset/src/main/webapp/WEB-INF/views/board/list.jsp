<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
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
				<p>${stockName }</p>
				<h2>종목 토론실</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">

		<h2 id="elements">게시글 리스트 (${stockName })</h2>
		<!-- table -->
		<div class="table-wrapper">
			<table class="alt">
				<thead>
					<tr>
						<td>게시글 번호</td>
						<td>작성자</td>
						<td>제목</td>
						<td>작성일</td>
						<td>조회수</td>
						<td>추천수</td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty boardList }">
						<tr>
							<td colspan="6">등록된 글이 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="board" items="${boardList }">
						<c:if test="${board.del == 'y' }">
							<tr>
								<td>${board.idx }</td>
								<td colspan="5">삭제된 글입니다.</td>
							</tr>
						</c:if>
						<c:if test="${board.del == 'n' }">
							<tr>
								<td>${board.idx }</td>
								<td>${board.m_id }</td>
								<td><a href="${path }/board/read?code=${board.s_code }&idx=${board.idx }">${board.title }</a></td>
								<td>${board.reg_date }</td>
								<td>${board.readcount }</td>
								<td>${board.likecount }</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			<form method="${path }/board/list?code=${param.code }" action="post">
				<div class="row uniform">
					<div class="3u 12u$(small)">
						<div class="select-wrapper">
							<select name="category" id="category">
								<option value="1">제목</option>
								<option value="2">작성자</option>
								<option value="3">내용</option>
							</select>
						</div>
					</div>
					<div class="6u 12u$(small)">
						<input type="text" name="query" id="" value=""
							placeholder="Code or Name" />
					</div>
					<div class="3u$ 12u$(small)">
						<input type="submit" value="검색" class="fit" />
					</div>
				</div>
			</form>
			<div style="text-align: right;">
				<a href="${path }/board/writeForm?code=${param.code }"
					class="button special">새 글 작성</a>
			</div>
		</div>
		<hr />
		페이징
	</div>

	<!-- Footer -->
	<footer id="footer">
		<div class="container">
			<ul class="icons">
				<li><a href="" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
				<li><a href="" class="icon fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="" class="icon fa-envelope-o"><span
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