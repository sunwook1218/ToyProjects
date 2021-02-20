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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$(document).ready(function () {
			var num = 1;
			if (num <= 8) {
				$(".add_row").click(function () {
					if (num <= 0) {
						num = 0;
					}
					num = num + 1;
					$(".port_list").append("<div class='row uniform list" + num + "'><div class='6u 12u$(xsmall)'><input type='text' name='code' placeholder='Code' /></div><div class='6u$ 12u$(xsmall)'><input type='number' name='ratio' placeholder='Ratio' /></div></div>");
				})

			}

			$(".delete_row").click(function () {
				$(".list" + num).remove();
				num = num - 1;
			})

		});
		function allowDrop(ev) {
			ev.preventDefault();
		}

		function drag(ev) {
			ev.dataTransfer.setData("text", ev.target.id);
		}

		function drop(ev) {
			ev.preventDefault();
			var data = ev.dataTransfer.getData("text");
			ev.target.appendChild(document.getElementById(data));
		}
	</script>
	<style>
		input[type="number"] {
			background: rgba(0, 0, 0, 0.075);
			border-color: rgba(0, 0, 0, 0.15);
			margin-bottom: 0;
			margin-top: 0;
			appearance: none;
			border-radius: 2px;
			height: 2.75rem;
			border: solid 1px;

			display: block;
			outline: 0;
			padding: 0 1rem;
			text-decoration: none;
			width: 100%;
		}
	</style>
</head>

<body class="subpage">

	<mytag:navbar></mytag:navbar>

	<!-- One -->
	<section id="One" class="wrapper style3">
		<div class="inner">
			<header class="align-center">
				<p>Eleifend vitae urna</p>
				<h2>Custom Fund</h2>
			</header>
		</div>
	</section>

	<!-- Two -->
	<section id="two" class="wrapper style2">
		<div class="inner">
			<div class="box">
				<div class="content">

					<form action="${ctxPath }/writefund.do" method="post" enctype="multipart/form-data">
						<input type="file" name="file1" />
						<div id="dropZone"
							style="border: 1px solid black; height: 150px; text-align: center; border-radius: 5px; ">
							Drag & Drop</div>
						<hr />
						<input type="text" name="title" placeholder="title" />
						<hr />
						<input type="text" name="sub_title" placeholder="sub title" />

						<hr />
						<textarea style="resize: none;" name="content" id="" cols="30" rows="10"
							placeholder="content"></textarea>

						<!-- Break -->
						<hr />
						<div class="port_list alt">
							<div class="row uniform">
								<div class="6u 12u$(xsmall)">
									<input type="text" name="code" placeholder="Code" />
								</div>
								<div class="6u$ 12u$(xsmall)">
									<input type="number" name="ratio" placeholder="Ratio" />
								</div>
							</div>
						</div>
						<hr />
						<div style="text-align: right;">
							<input type="submit" class="button special" />
						</div>
					</form>
					<button class="add_row special">추가</button>
					<button class="delete_row alt">제거</button>

				</div>
			</div>
		</div>
	</section>

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
	<script src="${ctxPath}/assets/js/jquery.min.js"></script>
	<script src="${ctxPath}/assets/js/jquery.scrollex.min.js"></script>
	<script src="${ctxPath}/assets/js/skel.min.js"></script>
	<script src="${ctxPath}/assets/js/util.js"></script>
	<script src="${ctxPath}/assets/js/main.js"></script>
	<script src="${ctxPath}/assets/js/writeFund.js"></script>

</body>

</html>