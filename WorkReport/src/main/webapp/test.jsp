<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int n = Integer.parseInt(request.getParameter("val"));

for(int i = 1; i <= 10; i++){
	out.print(i*n+"<br>");
}
%>