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
	  	<h1><%=request.getAttribute("customer_id") %> Paying off the loan account <%= request.getAttribute("loginName") %>.</h1>
		<p>You currently owe <%= request.getAttribute("owedAmount") %> but your required payment is <%=request.getAttribute("iRP") %> which is due by <%=request.getAttribute("dueDate") %></p>
		
		<!-- Select one of your accounts to transfer to -->
		<form action="validatePayAccount" class="text-center"> 
			<fieldset>
				<div class="form-group">
					<label for="accounts">Select an existing account to transfer money from:</label>
					<select class="form-control" id="accounts" name="accounts" required>
						<c:forEach var="account" items="${accounts}">
							<option value="<c:out value="${account.accountBalance}" />and<c:out value="${account.accountID}" />and<c:out value="${account.accountType}" />">Owner=<c:out value="${account.owner}" />, type=<c:out value="${account.accountType}" />, id=<c:out value="${account.accountID}" />, balance=<c:out value="${account.accountBalance}" /></option>
						</c:forEach>
					</select>
				</div><br><br>
				
				<label for="pay_Amount">How much would you like to pay:</label><br><br>
				<p>$<input type="number" id="pay_Amount" name="pay_Amount" min="50.00" max="<%= request.getAttribute("owedAmount") %>" value="50.00" step="0.01"></p>

				<input type="hidden" id="customer_id" name="customer_id" value=<%=request.getAttribute("customer_id") %>>
				<input type="hidden" id="loginName" name="loginName" value=<%= request.getAttribute("loginName") %>>
				<input type="hidden" id="owedAmount" name="owedAmount" value=<%= request.getAttribute("owedAmount") %>>
				<input type="hidden" id="receiveID" name="receiveID" value=<%= request.getAttribute("receiveID") %>>
				<input type="hidden" id="cIPR" name="cIPR" value=<%= request.getAttribute("cIPR") %>>
				<input type="hidden" id="iRP" name="iRP" value=<%= request.getAttribute("iRP") %>>
				
				<input type="submit" value="Pay Money"> 
			</fieldset> 
		</form>
	</body>
</html>