<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Stylesheets/update.css">
</head>
<body>
     <%  
         user=(User)session.getAttribute("user");
         Integer userId=(user!=null)?user.getId():0;
         String username=(user!=null)?user.getUsername():"";
         String email=(user!=null)?user.getEmail():"";
         String password=(user!=null)?user.getPassword():"";   
         
         String success=(String)request.getAttribute("success");
         String failure=(String)request.getAttribute("failure");
         if(success!=null){
     %>
         <p id="success" ><%=success %></p>  
         <%} 
         if(failure!=null){%>
              <p id="failure" ><%=failure %></p>
         <%} %>
            
	<form action="update" method="post">
	<h1>Update</h1>
	<input type="number" name="userId" value="<%= userId %>" readonly="readonly" hidden="true">
	<input type="text" name="username" value="<%=username %>">
	<input type="email" name="email" value="<%=email %>">
	<input type="password" name="password" value="<%=password %>"><br><br>
	<input type="submit" value="confirm">
	</form>
</body>
</html>