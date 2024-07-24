<%@page import="com.practise.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact-Management-System</title>
<link rel="stylesheet" href="Stylesheets/navbar.css">
</head>
<body>

<%User user=(User) session.getAttribute("user"); %>
   <div class="border">	  
	 <span>Contact-Management-System</span>	
	
	 <%if(user==null){ %>
		
		<button><a href="register.jsp" >Register</a></button>	
		<button><a href="login.jsp">Login</a></button>
		
		<%}else{ %>
		
		<button><a href="logout">Logout</a></button>
		
		<%}%>
	</div> 
	
	<!-- <div>
	    <span>Contact-Management-System</span>
		<button><a href="register.jsp" >Register</a></button>	
		<button><a href="login.jsp">Login</a></button>
	</div> -->
		
</body>
</html>