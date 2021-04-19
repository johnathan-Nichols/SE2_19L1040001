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
	  	<h1><%=request.getAttribute("customer_id") %>Creating a savings account for <%= request.getAttribute("loginName") %>.</h1>
	  	
     	<form action="validateCreateSavingsAccount"> 
	<fieldset>
		<h3>To create a savings account you must enter the term of the savings period.</h3>
		<p>During this period, you may withdraw or transfer money but you will lose any benefit on the money transfered or if you go below the minimum amount.</p><br><br>
		
		<label for="select">Select the length of savings:</label>
		<select class="form-control" id="increaseRate" name="increaseRate" required>
			<option value=0>6 month deposit. Gain 0.025% every year.</option>
			<option value=1>12 month deposit. Gain 0.03% every year.</option>
			<option value=2>18 month deposit. Gain 0.035% every year.</option>
			<option value=3>24 month deposit. Gain 0.04% every year.</option>
		</select><br>
		
		<div class="form-group">
			<label for="select">Select an existing account to transfer money from:</label>
			<select class="form-control" id="accounts" name="accounts" required>
				<c:forEach var="account" items="${accounts}">
					<option value="<c:out value="${account.accountBalance}" />and<c:out value="${account.accountID}" />and<c:out value="${account.accountType}" />">Owner=<c:out value="${account.owner}" />, type=<c:out value="${account.accountType}" />, balance=<c:out value="${account.accountBalance}" /></option>
				</c:forEach>
			</select>
		</div><br><br>
		
		<label for="quantity">How much would you like to transfer:</label><br><br>
		<p>$<input type="number" id="accountBalance" name="accountBalance" min="50.00" value="50.00" step="0.01"></p>
						
		<input type="hidden" id="customer_id" name="customer_id" value=<%=request.getAttribute("customer_id") %>>
		<input type="hidden" id="loginName" name="loginName" value=<%= request.getAttribute("loginName") %>>
		<input type="submit" value="Request a Savings Account"> 
	</fieldset> 
</form>
	</body>
</html>