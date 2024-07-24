<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contact</title>
<link rel="stylesheet" href="Stylesheets/addContact.css">
</head>
<body>
     <%  String success=(String)request.getAttribute("success");
         String failure=(String)request.getAttribute("failure");
         if(success!=null){
     %>
       <p id="success"><%=success %>!!!</p>
        
        <%} if(failure!=null){ %>
 
        <h1 id="failure"><%= failure %></h1>
        <%} %>
    <form action="addContact" method="post">
        <h1>Add Contact</h1>
        <input type="text" name="contactname" placeholder="Enter the contactName">
        <input type="text" name="contactNumber" placeholder="Enter the contactNumber"><br>
        <input id="submit" type="submit" value="confirm">
    </form>
</body>
</html>