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
	  	<h1><%=request.getAttribute("customer_id") %>Creating a loan account for <%= request.getAttribute("loginName") %>.</h1>
	  	
     	<form action="validateCreateLoanAccount"> 
			<fieldset>
				<h3>To create a loan account you must enter the amount of the loan that you would like and wait for it to be accepted or denied.</h3>
				<p>To expedite the loan process, please visit a local GoComBank branch and speak to a banker.</p><br><br>
				
				<label for="accountBalance">What is the amount that you would like to be loaned to you:</label><br><br>
				<p>$<input type="number" id="accountBalance" name="accountBalance" min="10000" value="10000" step="1000"></p>
				
				<input type="hidden" id="customer_id" name="customer_id" value=<%=request.getAttribute("customer_id") %>>
				<input type="hidden" id="loginName" name="loginName" value=<%= request.getAttribute("loginName") %>>
				
				<input type="submit" value="Request a Loan Account"> 
			</fieldset> 
		</form>
	</body>
</html>