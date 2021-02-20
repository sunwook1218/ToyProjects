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
	<link rel="stylesheet" href="${path }/resources/css/main.css" />
</head>

<body class="subpage">

	<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Asset Management</p>
				<h2>Fund</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">

		<!-- Elements -->
		<h2 id="elements">Fund</h2>
		<div class="row">
		<% int idx = 0; %>
			<c:forEach var="fund" items="${fundList }">
			<% idx++; %>
			<% if(idx % 3 != 0) { %>
				<div class="4u">
					<div class="box">
						<div class="image fit">
							<img src="<%= request.getContextPath() %>/images/fund/${fund.fundId }/${fund.fileName}" alt="" />
						</div>
						<div class="content">
							<header class="align-center">
								<p>NEW FUND</p>
								<h2>${fund.title }</h2>
							</header>
							<p class="align-center">${fund.subTitle }</p>
							<footer class="align-center">
								<a href="${ctxPath }/readfund.do?no=${fund.fundId}" class="button alt">Learn More</a>
							</footer>
						</div>
					</div>
				</div>
				<% } else { %>
				<div class="4u$">	
					<div class="box">
						<div class="image fit">
							<img src="<%= request.getContextPath() %>/images/fund/${fund.fundId }/${fund.fileName}" alt="" />
						</div>
						<div class="content">
							<header class="align-center">
								<p>NEW FUND</p>
								<h2>${fund.title }</h2>
							</header>
							<p class="align-center">${fund.subTitle }</p>
							<footer class="align-center">
								<a href="${ctxPath }/readfund.do?no=${fund.fundId}" class="button alt">Learn More</a>
							</footer>
						</div>
					</div>
				</div>
				<% } %>
			</c:forEach>
			<div class="12u" style="text-align: center;">
				<a href="${ctxPath }/writefund.do" class="button special">Make Custom Fund</a>
			</div>
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
	<script src="${path }/resources/js/jquery.min.js"></script>
	<script src="${path }/resources/js/jquery.scrollex.min.js"></script>
	<script src="${path }/resources/js/skel.min.js"></script>
	<script src="${path }/resources/js/util.js"></script>
	<script src="${path }/resources/js/main.js"></script>

</body>

</html>