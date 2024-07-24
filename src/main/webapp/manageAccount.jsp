<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Stylesheets/manageAccount.css"> 
</head>
<body>   
   <%  String success=(String)request.getAttribute("success");
         String failure=(String)request.getAttribute("failure");
         if(success!=null){
     %>
        <p><%=success %>!!!</p>
        
        <%} if(failure!=null){ %>
 
        <p class="failure"> <%=failure %></p>
        <%} %>
   
  <div id="update">
    <h1>Manage Account</h1>
     <button><a href="update.jsp">Edit Account</a></button><br>
      <button><a href="delete">Delete Account</a></button>
      </div>
      
   <%--  <% String success=(String)request.getAttribute("success"); %>
    <% String failure=(String)request.getAttribute("failure"); %>
    
	<%if(success!=null){%>
     <h4><%=success%></h4>
     <%} %>
     
     <%if(failure!=null){%>
     <h4><%=failure%></h4>
     <%} %> --%>
</body>
</html>