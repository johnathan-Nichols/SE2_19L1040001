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
	  	<h1><%=request.getAttribute("customer_id") %>Creating a checking account for <%= request.getAttribute("loginName") %>.</h1>
	  	
     	<c:choose>
     		<c:when test="${hasAccounts==true}">
				<form action="validateCreateCheckingAccount" class="text-center"> 
					<fieldset>
						<h3 class="text-center">To create a checking account you must add an initial deposit of $50.00</h3>
						<p>Remember each account must have at least $50.00 in it or you risk having your account locked.</p><br><br>
						
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
						
						<input type="submit" value="Create Checking Account"> 
					</fieldset> 
				</form>
			</c:when>
			<c:otherwise>
				<p>You do not have an account with enough money to open a new checking account. Please visit a GoComBank branch to open a new account.</p>
			</c:otherwise>
		</c:choose>
	</body>
</html>