<%@page import="com.practise.entity.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="Stylesheets/update_contact.css" >
</head>
<body>

       <%  Contact contact=(Contact)request.getAttribute("contact"); %>


       <form action="edit" method="post">
        <h1>Update Contact</h1>
        <input type="text" name="contactId" value="<%=contact.getContactId()%>" hidden="true">
        <input type="text" name="contactname" value="<%=contact.getContactName()%>">
        <input type="text" name="contactNumber" value="<%=contact.getContactNumber()%>"><br>
        <input id="submit" type="submit" value="confirm">
    </form>  
</body>
</html>