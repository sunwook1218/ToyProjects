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
	<link rel="stylesheet" href="${path }/resources/css/main.css" />
</head>

<body class="subpage">

<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Sed amet nulla</p>
				<h2>Modify Form</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">
		<!-- Elements -->
		<h2 id="elements">게시글 수정</h2>
					<!-- Form -->
					<form method="post" action="${path }/board/modify?code=${param.code }&idx=${param.idx }" >
						<div class="row uniform">
						<h3>타이틀</h3>
							<div class="12u$ ">
								<input type="text" name="title" value="${board.title }" placeholder="Title" />
							</div>
							<!-- text context -->
						<h3>내용</h3>
							<div class="12u$">
								<textarea name="content" placeholder="Content" 
									rows="6">${board.content }</textarea>
							</div>
							<!-- Break -->
							<div class="12u$">
								<ul class="actions">
									<li><input type="submit" value="등록" /></li>
									<li><input type="reset" value="모두 지우기" class="alt" /></li>
								</ul>
							</div>
						</div>
					</form>

					<hr />

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
		<script src="${path }/resources/js/jquery.min.js"></script>
		<script src="${path }/resources/js/jquery.scrollex.min.js"></script>
		<script src="${path }/resources/js/skel.min.js"></script>
		<script src="${path }/resources/js/util.js"></script>
		<script src="${path }/resources/js/main.js"></script>

</body>

</html>