<%@page import="com.practise.entity.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="Stylesheets/show_contact.css" >
</head>
<body>
  <table>
     <tr>
     <th>contact Id</th>
     <th>contact Name</th>
     <th>contact Number</th>
     <th>Edit</th>
     <th>Delete</th>
     </tr>
     
     <%  
         List<Contact> contacts=(List<Contact>)request.getAttribute("contacts");
     if(contacts!=null){
            for(Contact contact:contacts){
     %>
       <tr>
          <td> <%=contact.getContactId() %></td>
          <td> <%=contact.getContactName() %></td>
          <td> <%=contact.getContactNumber() %></td>
          <td> <a href="update-Contact?contactId=<%= contact.getContactId() %>"> edit </a> </td>
          <td> <a href="deleteContact?contactId=<%= contact.getContactId() %>"> delete</a> </td>
       </tr>
     <%}} %>
  </table>
</body>
</html>