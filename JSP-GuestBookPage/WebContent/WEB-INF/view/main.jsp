<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script>
	$(function() {
		$('#myModal').on('shown.bs.modal', function () {
			  $('#myInput').trigger('focus')
		});
		
		$('#exampleModal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  var recipient = button.data('whatever') // Extract info from data-* attributes
			  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			  var modal = $(this)
			  modal.find('.modal-title').text(recipient + '번 글 삭제하기')
			  modal.find('.modal-body input').val(recipient)
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>

	${info }
	<c:remove var="info" />
	<div class="container">
	<form action="write" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">이름</label>
    <input required="required" type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input required="required" type="password" name="password" class="form-control" id="exampleInputPassword1">
  </div>
    <div class="form-group">
    <label for="exampleFormControlTextarea1">메세지</label>
    <textarea required="required" class="form-control" name="message" id="exampleFormControlTextarea1" rows="3"></textarea>
  </div>
  <button type="submit" class="btn btn-primary">메세지 남기기</button>
</form>
	</div>
	
	<hr />
	<div class="container">
	
		<c:forEach var="message" items="${list.messageList }">
		<div class="media">
			<span>${message.id } &nbsp;</span>
			<div class="media-body">
				<h5 class="mt-0">${message.guestName }</h5>
				${message.message }
				<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal" data-whatever="${message.id }">삭제하기</button>
			</div>
		</div>
		</c:forEach>
	</div>
	<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
      <li class="page-item"><a class="page-link" href="#">Previous</a></li>
  		<c:forEach var="i" begin="1" end="${list.pageTotalCount }">  
			<li class="page-item"><a class="page-link" href="main?page=${i }">${i }</a></li>
		</c:forEach>
		<li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</nav>

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">New message</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="delete" method="post">
        <div class="form-group">
            <label for="recipient-name" class="col-form-label">id:</label>
            <input type="text" name="id" class="form-control" id="delete-id">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">password:</label>
            <input type="password" name="password" class="form-control" id="delete-password">
          </div>
                <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
        <button type="submit" class="btn btn-danger">메세지 삭제하기</button>
      </div>
        </form>
      </div>

    </div>
  </div>
</div>
</body>
</html>