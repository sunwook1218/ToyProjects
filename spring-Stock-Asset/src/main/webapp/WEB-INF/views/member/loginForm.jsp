<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<h2>Login</h2>
			</header>
		</div>
	</section>
	
	<!-- Main -->
	<div id="main" class="container">
		<hr />
		<!-- Form -->
		<h3>Login</h3>

		<form method="post" action="${path}/member/login">
			<div class="row uniform">
				<div class="6u 12u$(xsmall)">
					<input type="text" name="id" id="id" placeholder="ID" required="required" />
				</div>
				<div class="6u$ 12u$(xsmall)">
					<input type="password" name="password" id="password" placeholder="Password" required="required" />
				</div>
				<!-- break -->
				<div class="12u$">
					<ul class="actions">
						<li><input type="submit" value="Login" /></li>
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

</html>