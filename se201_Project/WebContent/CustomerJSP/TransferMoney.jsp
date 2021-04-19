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
	  	<h1><%=request.getAttribute("customer_id") %> Transferring money <%= request.getAttribute("loginName") %>.</h1>
		<p>You can transfer money into one of your accounts or you can enter the id and account type of another account that you would like to transfer money to.</p><br><br>
		
		<!-- Select one of your accounts to transfer to -->
     	<c:choose>
     		<c:when test="${hasAccounts==true}">
				<form action="validateTransferMoney" class="text-center"> 
					<fieldset>
						<div class="form-group">
							<label for="select">Select an existing account to transfer money to:</label>
							<select class="form-control" id="accounts" name="accounts" required>
								<c:forEach var="account" items="${accounts}">
									<option value="<c:out value="${account.accountBalance}" />and<c:out value="${account.accountID}" />and<c:out value="${account.accountType}" />">Owner=<c:out value="${account.owner}" />, type=<c:out value="${account.accountType}" />, id=<c:out value="${account.accountID}" />, balance=<c:out value="${account.accountBalance}" /></option>
								</c:forEach>
							</select>
						</div><br><br>
						
						<label for="accountBalance">How much would you like to transfer:</label><br><br>
						<p>$<input type="number" id="transfer_Amount" name="transfer_Amount" min="50.00" max="<%= request.getAttribute("mainAccountAmount") %>" value="50.00" step="0.01"></p>

						<input type="hidden" id="customer_id" name="customer_id" value=<%=request.getAttribute("customer_id") %>>
						<input type="hidden" id="loginName" name="loginName" value=<%= request.getAttribute("loginName") %>>
						<input type="hidden" id="transferID" name="transferID" value=<%= request.getAttribute("transferID") %>>
						<input type="hidden" id="mainType" name="mainType" value=<%= request.getAttribute("mainType") %>>
						<input type="hidden" id="mainID" name="mainID" value=<%= request.getAttribute("mainID") %>>
						<input type="hidden" id="mainAccountAmount" name="mainAccountAmount" value=<%= request.getAttribute("mainAccountAmount") %>>
						<input type="hidden" id="transferStyle" name="transferStyle" value=0>
						
						<input type="submit" value="Transfer Money"> 
					</fieldset> 
				</form>
			</c:when>
			<c:otherwise>
				<p>You do not have an account to transfer money to.</p>
			</c:otherwise>
		</c:choose><br><br><br>
		
		<!-- Enter an account to transfer money to -->
		<form action="validateTransferMoney" class="text-center"> 
			<fieldset>						
				<label for="quantity">What is the id of the account that you would like to transfer money to?</label>
				<input type="number" id="transfer_ID" name="transfer_ID" min="0" value="0" step="1">
				
				<div class="form-group">
					<label for="select">What is the account type?</label>
					<select class="form-control" id="transfer_Type" name="transfer_Type" required>
						<option value=checking>Checking Account</option>
						<option value=savings>Savings Account</option>
					</select>
				</div><br><br>
						
				<label for="accountBalance">How much would you like to transfer:</label><br><br>
				<p>$<input type="number" id="transfer_Amount" name="transfer_Amount" min="50.00" max="<%= request.getAttribute("mainAccountAmount") %>" value="50.00" step="0.01"></p>
				
				

						<input type="hidden" id="customer_id" name="customer_id" value=<%=request.getAttribute("customer_id") %>>
						<input type="hidden" id="loginName" name="loginName" value=<%= request.getAttribute("loginName") %>>
						<input type="hidden" id="transferID" name="transferID" value=<%= request.getAttribute("transferID") %>>
						<input type="hidden" id="mainType" name="mainType" value=<%= request.getAttribute("mainType") %>>
						<input type="hidden" id="mainID" name="mainID" value=<%= request.getAttribute("mainID") %>>
						<input type="hidden" id="mainAccountAmount" name="mainAccountAmount" value=<%= request.getAttribute("mainAccountAmount") %>>
						<input type="hidden" id="transferStyle" name="transferStyle" value=1>
				
				<input type="submit" value="Transfer Money"> 
			</fieldset> 
		</form>
		
	</body>
</html>