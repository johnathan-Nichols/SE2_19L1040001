<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="utf-8">
    <title><%= request.getAttribute("loginName") %></title>
  </head>
  <body class="text-center">
		<a href="login">Log Out</a>
	  	<h1><%=request.getAttribute("customer_id") %> paying money <%= request.getAttribute("loginName") %>.</h1>
		<p>Are you sure that you would like to pay $<%=request.getAttribute("payAmount") %> to the loan account <%=request.getAttribute("receiveID") %>?</p><br><br>
		
		<a class="btn btn-primary" href="sendPayAccount?iRP=<%=request.getAttribute("iRP") %>&loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>&pay=<%=request.getAttribute("pay") %>" role="button">Yes</a><a class="btn btn-primary" href="sendTransferMoney?loginName=<%=request.getAttribute("loginName") %>&cancel=true" role="button">No</a>

	</body>
</html>