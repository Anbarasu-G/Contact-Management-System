<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="Stylesheets/register.css">
</head>
<body>

	<form action="register" method="post">
	<h1>Register</h1>
	<input type="text" name="username" placeholder="Enter username">
	<input type="email" name="email" placeholder="Enter email">
	<input type="password" name="password" placeholder="Enter password"><br>
	<input type="submit" value="Register">
	</form>
	
	<%
	String failure=(String)request.getAttribute("failure"); 
	 if(failure!=null){
	%>
	<h4 style="color: red ;"><%=failure%></h4>
    <%} %>
</body>
</html>