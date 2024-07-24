<%@page import="com.practise.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="navbar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="Stylesheets/index.css">
</head>
<body>

   <% 
   User user2=(User)session.getAttribute("user");
   String  addContacts=(user2!=null)?"addContact.jsp":"login.jsp";
   String  manageContact=(user2!=null)?"show_contact":"login.jsp";
   String  manageAccount=(user2!=null)?"manageAccount.jsp":"login.jsp";
   %>
	
	<div id="index">

		<h2 id="welcome">Welcome</h2>
		
		<button><a href="<%= addContacts%>">Add Contact</a></button>
		<button><a href="<%= manageContact%>">Manage Contact </a></button>
		<button><a href="<%= manageAccount%>">Manage Account </a></button>
		
	</div>
	
</body>
</html>