<%@page import="com.practise.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="Stylesheets/login.css">
</head>
<body>

  
  <%  
	String msg=(String)request.getAttribute("error"); 
	if(msg!=null){
	%>	
	<p><%=msg%></p>
    
 <%} %>
     
	<form action="login" method="post">
	<h1>Login</h1>
	<input type="email" name="email" placeholder="Enter email">
	<input type="password" name="password" placeholder="Enter password"><br>
	<input type="submit" value="Login">
	</form>
</body>
</html>