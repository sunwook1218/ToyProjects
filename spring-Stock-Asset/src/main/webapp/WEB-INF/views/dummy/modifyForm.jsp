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
	<link rel="stylesheet" href="${ctxPath }/assets/css/main.css" />
	<c:if test="${result == -1 }">
		<script type="text/javascript">
			alert("당신의 게시글이 아닙니다.");
			location.href="${path}/board/list?code=${param.code}";
		</script>
	</c:if>
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
		<h2 id="elements">포트 수정</h2>
					<!-- Form -->
					<h3>Form</h3>

					<form method="post" action=""  enctype="multipart/form-data">
						<div class="row uniform">
							<div class="12u$ ">
								<input type="text" name="title" value="${modReq.title }" placeholder="Title" />
							</div>
							<div class="4u 12u$(xsmall)">
								<input type="text" name="inv_where" value="${modReq.inv_where }" placeholder="code" />
							</div>
							<div class="4u 12u$(xsmall)">
								<input type="text" name="inv_howmuch" value="${modReq.inv_howMuch }" placeholder="amount" />
							</div>
							<div class="4u$ 12u$(xsmall)">
								<input type="text" name="inv_when" value="${modReq.inv_when }" placeholder="date" />
							</div>
							<!-- text context -->
							<div class="12u$">
								<textarea name="content" placeholder="Content" 
									rows="6">${modReq.content }</textarea>
							</div>
							<!-- Break -->
							<input type="file" name="file1" accept="image/*"/>
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

					<form method="post" action="write.do"  enctype="multipart/form-data">
						<div class="row uniform">
							<div class="9u 12u$(small)">
								<input type="text" name="query" id="query" value="" placeholder="Query" />
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