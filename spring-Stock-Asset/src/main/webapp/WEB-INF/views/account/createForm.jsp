<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Account Opening</title>
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
				<h2>Account Opening</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">

		<!-- Elements -->
		<div class="row 200%">
			<div class="6u 12u$(medium)">

				<h2 style="font-weight: bold;">원터치 계좌개설 서비스</h2>
				<p>계좌 개설 시 <b>300만원</b> 지급 이벤트 진행중!</p>
				<p>2020.10.12 ~ 2020.10.28</p>
				<hr />
				<!-- Form -->

				<form method="post" action="${path }/account/create">
					<div class="row uniform">
						<input type="hidden" name="m_idx" value="${authUser.idx }" /> 
						<input type="hidden" name="balance" value="3000000" />
						<span>계좌 개설 목적을 작성해주세요. 작성하지 않으면 기본값으로 '증권거래용' 이라고 기입됩니다.</span>
						<div class="6u 12u$(xsmall)">
							<input type="text" name="remark" value="증권거래용" placeholder="remark" />
						</div>
						<div class="6u$ 12u$(xsmall)">
							<input type="submit" value="원터치 계좌개설" />
						</div>
						
					</div>
				</form>
			</div>
		</div>
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