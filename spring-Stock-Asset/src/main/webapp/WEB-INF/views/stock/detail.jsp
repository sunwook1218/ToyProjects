<%@page import="com.sun.scrapper.CompanyInfoTableScrapper"%>
<%@page import="com.sun.scrapper.NewsScrapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.util.*, java.sql.*, java.text.SimpleDateFormat"%>
<%@ page import="com.sun.scrapper.PriceScrapper" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML>
<html>

<head>
	<title>Detail</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="${path }/resources/css/main.css" />
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load('current', { 'packages': ['corechart'] });
		google.charts.setOnLoadCallback(drawChart);

		var arr = [
	<c:forEach var="quotation" items="${list}">
	 ['${quotation.date}', ${quotation.lq}, ${quotation.oq}, ${quotation.cq}, ${quotation.hq} ],
	</c:forEach>
		];
		arr.reverse();
		function drawChart() {
			var data = google.visualization.arrayToDataTable(arr, true);

			var options = {
				legend: { position: 'relative' },
				series: [
					{ fallingColor: 'red', visibleInLegend: false }, {}, {},
					{ color: 'black', visibleInLegend: false }
				],
				chartArea: { height: '85%' }

			};

			var chart = new google.visualization.CandlestickChart(document.getElementById('chart_div'));

			chart.draw(data, options);
		}
	</script>
</head>

<%
	String code = request.getParameter("code");
 	ArrayList news = NewsScrapper.getNewsList(code);
 	request.setAttribute("news", news);
 	
 	ArrayList companyInfo = CompanyInfoTableScrapper.getTable(code);
 	request.setAttribute("info", companyInfo);
 	
 	String priceStr = PriceScrapper.getPrice(code);
 	
 	int price = Integer.parseInt(PriceScrapper.removeComma(priceStr));
 	
 	request.setAttribute("price", price);

%>

<body class="subpage">

	<mytag:navbar/>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>${param.code}</p>
				<h2>${s_name }</h2>
			</header>
		</div>
	</section>

	<!-- Main -->
	<div id="main" class="container">
		<!-- Search Bar -->
		<form method="" action="${path }/stock/search?query=${param.query }">
			<div class="row uniform">
				<div class="9u 12u$(small)">
					<input type="text" name="query" id="" value="" placeholder="Code or Name" />
				</div>
				<div class="3u$ 12u$(small)">
					<input type="submit" value="Search" class="fit" />
				</div>
			</div>
		</form>
		
		<div class="align-center"><h2 style="font-weight: bold;"> 현재가 : <%= priceStr %> </h2></div>

		<!-- chart-->
		<hr>
		<div id="chart_div" style="height: 600px"></div>
		<br />
		<div style="text-align: center;">
			<a href="${path }/stock/update?code=${param.code }" class="button special">종목최신화</a>
			<a href="${path }/board/list?code=${param.code }" class="button">종목토론실</a>
		</div>
		<hr>
	
		<h2 id="elements">Information</h2>
		<div class="row 200%">
			<div class="6u 12u$(medium)">
				<!-- Table -->
				<h3>Fundamental</h3>
					<c:forEach var="info" items="${info }">
						<div class="table-wrapper">
							${info }
						</div>
					</c:forEach>
			</div>

			<div class="6u$ 12u$(medium)">
				<hr />
				<!-- Form -->
				<h3 style="font-weight: bold">트레이딩</h3>
				
				<form method="post" action="${path }/stock/trading">
					<div class="row uniform">
						<div class="6u 12u$(xsmall)">
							<input type="number" name="price" value ="${price }" readOnly />
						</div>
						<div class="6u$ 12u$(xsmall)">
							<input type="text" name="s_code" value="${param.code }" placeholder="code"  />
						</div>
						<div class="6u 12u$(xsmall)">
							<span>현재 보유량 : </span>
							<input type="text" name="h_amount" value="${reserve }" readonly="readonly" />
						</div>
						<div class="6u$ 12u$(xsmall)">
							<span>수량 : </span>
							<input type="number" name="amount" placeholder="amount"  min="1"/>
						</div>
						<!-- Break -->
						<div class="6u 12u$(small)">
								<input type="radio" id="priority-low" name="action" value="p" checked>
								<label for="priority-low">매수</label>
						</div>
						<div class="4u 12u$(small)">
								<input type="radio" id="priority-normal" name="action" value="s" >
								<label for="priority-normal">매도</label>
						</div>
						<!-- Break -->
						<div class="12u$">
							<ul class="actions">
								<li><input type="submit" value="거래" /></li>
							</ul>
						</div>
					</div>
				</form>
					<hr />
				<header>
					<h2>News</h2>
					<p>실시간 주요뉴스</p>
				</header>
				<header>
				<c:forEach var="news" items="${news }" >
					<h3 style="font-weight: bold"><a href="${news.link }">${news.title }</a></h3>
					<p>${news.info }  / ${news.date }</p>
				</c:forEach>
				</header>
	 		

				

			</div>
		</div>
		
		<mytag:SearchCode></mytag:SearchCode>

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