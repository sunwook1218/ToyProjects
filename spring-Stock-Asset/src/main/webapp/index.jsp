<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.sun.scrapper.*" %>
<%@ page import="com.sun.model.*" %>
<!DOCTYPE HTML>
<html>
	    <% 
			ArrayList pidaq = PIDAQMaker.get60();
			request.setAttribute("pidaqList", pidaq);
			
			ArrayList mainNews = MainNewsScrapper.getNewsList();
			request.setAttribute("main_news", mainNews);
	
			ArrayList popStock = PopularScrapper.getPopStocks();
			request.setAttribute("pop", popStock);
			
			ArrayList kospiStock = KOSPIScrapper.getKOSPIStocks();
			request.setAttribute("kospi", kospiStock);
			
			ArrayList kosdaqStock = KOSDAQScrapper.getKOSDAQStocks();
			request.setAttribute("kosdaq", kosdaqStock);
			
			ArrayList volume30 = Volume30Scrapper.get30();
			request.setAttribute("vol30", volume30);
		%>
<head>
	<title>Home</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" href="${path }/resources/css/main.css" />
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	
    	var dataSet = [
            <c:forEach var="pidaq" items="${pidaqList}">
            ['',  ${pidaq.kospi}, ${pidaq.kosdaq}],
            </c:forEach>
            ['Year', 'KOSPI', 'KOSDAQ']	
          ];
    	
    	dataSet.reverse();
    	
        var data = google.visualization.arrayToDataTable(dataSet);

        var options = {
          title: 'Quotation',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
</head>

<body>

	<mytag:navbar></mytag:navbar>
	
	<!-- Banner -->
	<section class="banner full">
		<article>
		<a href="${path }/index.jsp">
			<img src="${path }/resources/images/slide01.jpg" alt="" />
			<div class="inner">
				<header>
					<p>A free responsive web site for investment</p>
					<h2>Home</h2>
				</header>
			</div>
			</a>
		</article>
		<article>
		<a href="${path }/member/joinForm">
			<img src="${path }/resources/images/slide02.jpg" alt="" />
			<div class="inner">
				<header>
					<p>start your own investment with us</p>
					<h2>Join</h2>
				</header>
			</div>
			</a>
		</article>
		<article>
		<a href="${path }/stock/search">
			<img src="${path }/resources/images/slide03.jpg" alt="" />
			<div class="inner">
				<header>
					<p>see others portfolio</p>
					<h2>Stock</h2>
				</header>
			</div>
			</a>
		</article>
		<article>
		<a href="${path }/fund/list">
			<img src="${path }/resources/images/slide04.jpg" alt="" />
			<div class="inner">
				<header>
					<p>smart invest to investing our fund</p>
					<h2>Fund</h2>
				</header>
			</div>
			</a>
		</article>
		<article>
			<a href="${path }/member/mymenu">
			<img src="${path }/resources/images/slide05.jpg" alt="" />
			<div class="inner">
				<header>
					<p>write new your own portfolio</p>
					<h2>My Menu</h2>
				</header>
			</div>
		</article>
		</a>
	</section>
	<section  class="wrapper style2">
	<div class="inner">
	<h2>최근 동향</h2>
	<div id="curve_chart" style="width: 100%; height: 500px"></div>
	</div>
	</section>
	<!-- One -->
	<section id="one" class="wrapper style2">
		<div class="inner">
			<div class="grid-style">
				<c:forEach var="news" items="${main_news }">
					<div>
						<div class="box">
							<div class="content">
								<header class="align-center">
									<p>${news.info }</p>
									<h2>${news.title }</h2>
								</header>
								<p class="align-center"> ${news.date }</p>
								<footer class="align-center">
									<a href="${news.link }" class="button alt">Learn More</a>
								</footer>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Nam vel ante sit amet libero scelerisque facilisis eleifend vitae urna</p>
				<h2>종목 검색</h2>
			</header>
		</div>
	</section>
	
	

	<!-- Three -->
	<section id="three" class="wrapper style2">
		<div class="inner">
			<header class="align-center">
				<p class="special">Nam vel ante sit amet libero scelerisque facilisis eleifend vitae urna</p>
				<h2>종목 검색</h2>
			</header>
			<hr />
			<mytag:SearchCode/>
			<div class="row 200%">
				<div class="6u 12u$(medium)">
					<h3>거래량 상위</h3>
					<div class="table-wrapper">
						<table class="alt">
							<thead>
								<tr>
									<th>Rank</th>
									<th>Stock</th>
									<th>Code</th>
								</tr>
							</thead>
							<tbody>
								<% int index0 = 0; %>
								<c:forEach var="stock" items="${vol30 }">
									<% index0++; %>
									<tr>
										<td><%= index0 %></td>
										<td><a href="${path }/stock/detail?code=${stock.code }"><b>${stock.name }</b></a></td>
										<td>${stock.code }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="6u$ 12u$(medium)">
					<h3>인기 검색</h3>
					<div class="table-wrapper">
						<table class="alt">
							<thead>
								<tr>
									<th>Rank</th>
									<th>Stock</th>
									<th>Code</th>
								</tr>
							</thead>
							<tbody>
								<% int index1 = 0; %>
								<c:forEach var="stock" items="${pop }">
									<% index1++; %>
									<tr>
										<td><%= index1 %></td>
										<td><a href="${path }/stock/detail?code=${stock.code }"><b>${stock.name }</b></a></td>
										<td>${stock.code }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="6u 12u$(medium)">
					<h3>KOSPI TOP 30</h3>
					<div class="table-wrapper">
						<table class="alt">
							<thead>
								<tr>
									<th>Rank</th>
									<th>Stock</th>
									<th>Code</th>
								</tr>
							</thead>
							<tbody>
								<% int index3 = 0; %>
								<c:forEach var="stock" items="${kospi }">
									<% index3++; %>
									<tr>
										<td><%= index3 %></td>
										<td><a href="${path }/stock/detail?code=${stock.code }"><b>${stock.name }</b></a></td>
										<td>${stock.code }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="6u$ 12u$(medium)">
					<h3>KOSDAQ TOP30</h3>
					<div class="table-wrapper">
						<table class="alt">
							<thead>
								<tr>
									<th>Rank</th>
									<th>Stock</th>
									<th>Code</th>
								</tr>
							</thead>
							<tbody>
								<% int index4 = 0; %>
								<c:forEach var="stock" items="${kosdaq }">
									<% index4++; %>
									<tr>
										<td><%= index4 %></td>
										<td><a href="${path }/stock/detail?code=${stock.code }"><b>${stock.name }</b></a></td>
										<td>${stock.code }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
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
	<script src="${path }/resources/js/jquery.min.js"></script>
	<script src="${path }/resources/js/jquery.scrollex.min.js"></script>
	<script src="${path }/resources/js/skel.min.js"></script>
	<script src="${path }/resources/js/util.js"></script>
	<script src="${path }/resources/js/main.js"></script>
		<script type="text/javascript">
    var kkeys = [], konami = "38,38,40,40,37,39,37,39,66,65";
    $(document).keydown(function(e) {
        kkeys.push(e.keyCode);
        if (kkeys.toString().indexOf(konami) >= 0) {
            kkeys = [];
            alert("master menu로 이동합니다");
            <%
				request.getSession().setAttribute("master", "master");            
            %>
            location.href="/member/master";
        }
    });
	</script>

</body>

</html>