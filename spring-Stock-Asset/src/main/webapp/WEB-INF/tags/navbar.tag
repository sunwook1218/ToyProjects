<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<!-- Header -->
	<header id="header">
		<div class="logo"><a href="${path }/index.jsp">Home <span>investment</span></a></div>
		<c:if test="${not empty authUser }">
		<span>${authUser.name }님 / 예수금 : ${depositSum }</span>
		</c:if>
		<a href="#menu">Menu</a>
	</header>

	<c:if test="${not empty authUser }">
	<!-- Nav -->
	<nav id="menu">
		<ul class="links">
		<form action="${path }/stock/search?query=${param.query }"> <input style="color: white" type="text" name="query" placeholder="Search"/></form>
			<li><a href="${path }/index.jsp">Home</a></li>
			<li><a href="${path }/member/mymenu">My Menu</a></li>
			<li><a href="${path }/stock/search">Stock</a></li>
			<c:if test="${depositSum == 0}">
			<li><a href="${path }/account/createForm">Account</a></li>
			</c:if>
			<c:if test="${depositSum != 0}">
			<li><a href="${path }/account/manage">Account</a></li>
			</c:if>
			<li><a href="${path }/fund/list">Fund</a></li>
			<li><a href="${path }/member/logout">Logout</a></li>
		</ul>
	</nav>
	</c:if>
	<c:if test="${empty authUser }">
	<!-- Nav -->
	<nav id="menu">
		<ul class="links">
		<form action="${path }/stock/search?query=${param.query }"> <input style="color: white" type="text" name="query" placeholder="code"/></form>
			<li><a href="${path }/index.jsp">Home</a></li>
			<li><a href="${path }/stock/search">Stock</a></li>
			<li><a href="${path }/member/loginForm">Login</a></li>
			<li><a href="${path }/member/joinForm">Join</a></li>
			<li><a href="${path }/fund/list">Fund</a></li>
		</ul>
	</nav>
	</c:if>