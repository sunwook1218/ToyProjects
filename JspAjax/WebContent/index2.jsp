<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewpoint" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>JSP AJAX</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script type="text/javascript">

	let request = new XMLHttpRequest();
	
	function searchFunction() {
		request.open("Post", "./UserSearchServlet?userName=" + encodeURIComponent(document.getElementById("userName").value), true);
		request.onreadystatechange = searchProcess;
		request.send(null);
	}
	
	function searchProcess() {
		let table = document.getElementById("ajaxTable");
		table.innerHTML = "";
		
		if(request.readyState == 4 && request.status == 200) {
			
			let object = eval('(' + request.responseText + ')');
			let result = object.result;
			
			for(let i = 0; i < result.length; i++) {
				let row = table.insertRow(0);
				
				for(let j = 0; j < result[i].length; j++) {
					let cell = row.insertCell(j);
					cell.innerHTML = result[i][j].value;
				} 
			}
		}
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<br>
	<div class="container">
		<div class="form-group row pull-right">
			<div class="col-xs-8">
				<input class="form-control" onkeyup="searchFunction()" id="userName" type="text" size="20">
			</div>
			<div class="col-xs-2">
				<button class="btn btn-primary" onclick="searchFunction()" type="button">검색</button>
			</div>
		</div>
		<table class="table" style="text-align: center; border: 1px solid #dddddd;">
			<thead>
				<tr>
					<th style="background-color: #fafafa; text-align: center;">이름</th>
					<th style="background-color: #fafafa; text-align: center;">나이</th>
					<th style="background-color: #fafafa; text-align: center;">성별</th>
					<th style="background-color: #fafafa; text-align: center;">이메일</th>
				</tr>
			</thead>
			<tbody id="ajaxTable">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			</tbody>
		</table>
	</div>
</body>
</html>