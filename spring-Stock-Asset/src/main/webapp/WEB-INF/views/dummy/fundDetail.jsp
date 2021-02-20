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
	<link rel="stylesheet" href="${ctxPath}/assets/css/main.css" />
	    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          <c:forEach var="fundContent" items="${fundData.fundContentList}">
          ['${fundContent.code}', ${fundContent.ratio}],
          </c:forEach>
        ]);

        var options = {
          title: '구성 종목'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
      
      google.charts.load('current', { 'packages': ['corechart'] });
		google.charts.setOnLoadCallback(drawChart2);

		var arr = [
	<c:forEach var="quotation" items="${quotationList}">
	 ['', ${quotation.lq}, ${quotation.oq}, ${quotation.cq}, ${quotation.hq} ],
	</c:forEach>
		];
		arr.reverse();
		function drawChart2() {
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

<body class="subpage">

	<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Eleifend vitae urna</p>
				<h2>Generic Page Template</h2>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">
					<header class="align-center">
						<p>NEW FUND</p>
						<h2>${fundData.fund.title }</h2>
					</header>
					<div id="piechart" style="width: 900px; height: 500px;"></div>
					<hr>
					
					<div id="chart_div" style="height: 600px"></div>
					<hr>
					<h3 style="white-space: pre-wrap;">${fundData.fund.content }</h3>
					
				</div>
			</div>
			
			<hr>
			<div style="text-align: center;">
			<a href="<%= request.getContextPath() %>/fundlist.do" class="button special">Back to List</a>
			</div>
		</div>
	</section>

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
	<script src="${ctxPath}/assets/js/jquery.min.js"></script>
	<script src="${ctxPath}/assets/js/jquery.scrollex.min.js"></script>
	<script src="${ctxPath}/assets/js/skel.min.js"></script>
	<script src="${ctxPath}/assets/js/util.js"></script>
	<script src="${ctxPath}/assets/js/main.js"></script>

</body>

</html>