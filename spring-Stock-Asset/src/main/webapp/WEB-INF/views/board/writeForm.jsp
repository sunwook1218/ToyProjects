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
				<h2>Elements</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">

		<!-- Elements -->
		<h2 id="elements">게시글 작성</h2>
		<!-- Form -->
		<form action="${path }/board/write?code=${param.code }" method="post">
			<input type="hidden" name="m_idx" value="${authUser.idx }" /> 
			<input type="hidden" name="m_id" value="${authUser.id }" /> 
			<input type="hidden" name="s_code" value="${boardcode }" />
			<div class="row uniform">
				<div class="12u$ ">
					<input type="text" name="title" value="제목" placeholder="Title" required="required" />
				</div>
				<!-- text context -->
				<div class="12u$">
					<textarea name="content" placeholder="내용" rows="6" required="required" ></textarea>
				</div>
				<!-- Break -->
				<div class="12u$" style="text-align: right;">
					<ul class="actions">
						<li><input type="submit" value="등록" /></li>
						<li><input type="reset" value="모두 지우기" class="alt" /></li>
					</ul>
				</div>
			</div>
		</form>
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