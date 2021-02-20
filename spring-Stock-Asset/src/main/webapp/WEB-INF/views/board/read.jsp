<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>

<html>
<head>
	<title>Hielo by TEMPLATED</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="${path }/resources/css/main.css" />
</head>
<body class="subpage">

	<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Sed amet nulla</p>
				<h2>Board</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">
	
		<h2>${board.title }</h2>

		<!-- Box -->
		<h1>${board.m_id } / ${board.reg_date}</h1>
		<hr />
		<div class="box">
			<p style="white-space: pre-wrap;">
<c:out value="${board.content }"/>
			</p>
		</div>
		<c:if test="${board.m_idx == authUser.idx }">
		<div style="text-align: right;">
		<ul class="actions">
			<li><a href="${path }/board/modifyForm?code=${param.code }&idx=${param.idx }" class="button alt">수정</a></li>
			<li><a class="button special" data-toggle="modal" data-target="#exampleModalCenter">삭제</a></li>
		</ul>
		</div>
		</c:if>
		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalCenterTitle">게시글 삭제</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						정말로 게시글을 삭제하시겠습니까?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
						<a href="${path }/board/delete?code=${param.code }&idx=${param.idx }" class="button special">삭제</a>
					</div>
				</div>
			</div>
		</div>
		<hr />

		<h3>댓글</h3>
			<div class="table-wrapper ">
				<table>
					<tbody>
						<c:if test="${empty commentList }">
						<tr>
							<td>댓글이 없습니다.</td>
						</tr>
						</c:if>
						<c:if test="${not empty commentList }">
						<c:forEach var="comment" items="${commentList }">
						<tr>
							<td>${comment.writerName }</td>
							<td>${comment.content }</td>
							<td>${comment.regDate }</td>
							<td><a href="${path }/portfolio/comment/delete?comment_no=${comment.commentNumber}&article_no=${param.no}" class="button alt">삭제</a></td>
						</tr>
						</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		<br />
		<form method="post" action="${path }/board/read?code=${param.code }&idx=${param.idx }">
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
			<table class="alt">	
				<thead>
					<td>게시글 번호</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
					<td>조회수</td>
					<td>추천수</td>
				</thead>
				<tbody>
					<c:if test="${empty boardList }">
					<tr>
						<td>등록된 글이 없습니다.</td>
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
	<script src="${path }/resources/js/jquery.min.js"></script>
	<script src="${path }/resources/js/jquery.scrollex.min.js"></script>
	<script src="${path }/resources/js/skel.min.js"></script>
	<script src="${path }/resources/js/util.js"></script>
	<script src="${path }/resources/js/main.js"></script>

</body>

</html>