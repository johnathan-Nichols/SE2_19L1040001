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
	  <h1><%= request.getAttribute("customer_id") %>Viewing the accounts of <%= request.getAttribute("loginName") %>.</h1>
	  
	  <!-- Give a warning if a savings account is too low or if a Loan account is near due -->
	<div class="container">
	   	<c:set var = "hasCheckingAccount" scope = "session" value = "<%= request.getAttribute(\"hasAccountsChecking\") %>"/>
	   	<c:set var = "hasSavingsAccount" scope = "session" value = "<%= request.getAttribute(\"hasAccountsSavings\") %>"/>
     	<c:set var = "hasLoanAccount" scope = "session" value = "<%= request.getAttribute(\"hasAccountsLoan\") %>"/>
     	
   		<h3 class="text-center">Checking Account</h3>
     	<c:choose>
     		<c:when test="${hasCheckingAccount==true}">
	     		<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Transfer From This Account</th>
							<th>View Account History</th>
							<th>ID</th>
							<th>accountBalance</th>
							<th>creationDate</th>
							<th>validAccount</th>
							<th>activatedAccount</th>
							<th>Close Account</th>
						</tr>
					</thead>
					<tbody>
			      		<c:forEach var="checkingAccount" items="${checkingAccounts}">
						<tr>
							<c:choose>
				     			<c:when test="${checkingAccount.canTransfer}"><td><a style="" href="transferMoney?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>&main_type=checking&main_id=${checkingAccount.id}&mainAccountAmount=${checkingAccount.accountBalance}">Transfer</a></td></c:when>
				     			<c:otherwise><td><a style="pointer-events: none">Cannot Transfer</a></td></c:otherwise>
				     		</c:choose>
				     		<td><a href="transactionHistory?account_id=${checkingAccount.id}&accountType=checking">View</a></td>
							<td><c:out value="${checkingAccount.id}" /></td>
							<td><c:out value="${checkingAccount.accountBalance}" /></td>
							<td><c:out value="${checkingAccount.getCreationDate()}" /></td>
							<td><c:out value="${checkingAccount.validAccount}" /></td>
							<td><c:out value="${checkingAccount.activatedAccount}" /></td>
							
							<c:choose>
				     			<c:when test="${checkingAccount.accountBalance <= 0}"><td><a href="closeAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>&close_ID=${checkingAccount.id}&close_Type=checking">Close</a></td></c:when>
				     			<c:otherwise><td><a style="pointer-events: none">Cannot Close</a></td></c:otherwise>
				     		</c:choose>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<a href="createCheckingAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>">Request a new Checking Account?</a>
     		</c:when>
     		<c:otherwise>
     			<p>There are no Checking Accounts or an account has not been activated yet. Create a new account or wait for a banker to activate your account. Please visit a GoComBank branch to expedite this process.<br><a href="createCheckingAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>">Request a new Checking Account?</a></p>
     		</c:otherwise>
     	</c:choose>
     	
   		<h3 class="text-center">Savings Account</h3>
     	<c:choose>
     		<c:when test="${hasSavingsAccount==true}">
	     		<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Transfer From This Account</th>
							<th>View Account History</th>
							<th>ID</th>
							<th>accountBalance</th>
							<th>increasePercentage</th>
							<th>increaseRate</th>
							<th>lastIncrease</th>
							<th>creationDate</th>
							<th>validAccount</th>
							<th>activatedAccount</th>
							<th>Close Account</th>
						</tr>
					</thead>
					<tbody>
			      		<c:forEach var="savingsAccount" items="${savingsAccounts}">
						<tr>
							<c:choose>
				     			<c:when test="${savingsAccount.canTransfer}"><td><a style="" href="transferMoney?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>&main_type=savings&main_id=${savingsAccount.id}&mainAccountAmount=${savingsAccount.accountBalance}">Transfer</a></td></c:when>
				     			<c:otherwise><td><a style="pointer-events: none">Cannot Transfer</a></td></c:otherwise>
				     		</c:choose>
				     		
				     		<td><a href="transactionHistory?account_id=${savingsAccount.id}&accountType=<%=request.getAttribute("accountType") %>">View</a></td>
				     		<td><c:out value="${savingsAccount.id}" /></td>
							<td><c:out value="${savingsAccount.accountBalance}" /></td>
							<td><c:out value="${savingsAccount.increasePercentage}" /></td>
							<td><c:out value="${savingsAccount.increaseRate}" /></td>
							<td><c:out value="${savingsAccount.getLastIncrease()}" /></td>
							<td><c:out value="${savingsAccount.getCreationDate()}" /></td>
							<td><c:out value="${savingsAccount.validAccount}" /></td>
							<td><c:out value="${savingsAccount.activatedAccount}" /></td>
											     		
							<c:choose>
				     			<c:when test="${savingsAccount.accountBalance <= 0}"><td><a href="closeAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>&close_ID=${savingsAccount.id}&close_Type=savings">Close</a></td></c:when>
				     			<c:otherwise><td><a style="pointer-events: none">Cannot Close</a></td></c:otherwise>
				     		</c:choose>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<a href="createSavingsAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>">Request a new Savings Account?</a>
     		</c:when>
     		<c:otherwise>
     			<p>There are no Savings Accounts or an account has not been activated yet. Create a new account or wait for a banker to activate your account. Please visit a GoComBank branch to expedite this process.<br><a href="createSavingsAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>">Request a new Savings Account?</a></p>
     		</c:otherwise>
     	</c:choose>
     	
   		<h3 class="text-center">Loan Account</h3>
     	<c:choose>
     		<c:when test="${hasLoanAccount==true}">
	     		<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>Transfer From This Account</th>
							<th>View Account History</th>
							<th>ID</th>
							<th>accountBalance</th>
							<th>owedAmount</th>
							<th>increaseRate</th>
							<th>increaseInterval</th>
							<th>latePaymentPenalty</th>
							<th>intervalRequiredPayment</th>
							<th>currentIntervalPaymentReceived</th>
							<th>lastIntervalDate</th>
							<th>dueDate</th>
							<th>creationDate</th>
							<th>validAccount</th>
							<th>activatedAccount</th>
							<th>Pay Off Account</th>
							<th>Close Account</th>
						</tr>
					</thead>
					<tbody>
			      		<c:forEach var="loanAccount" items="${loanAccounts}">
						<tr>
							<c:choose>
				     			<c:when test="${loanAccount.canTransfer}"><td><a href="transferMoney?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>&main_type=loan&main_id=${loanAccount.id}&mainAccountAmount=${loanAccount.accountBalance}">Transfer</a></td></c:when>
				     			<c:otherwise><td><a style="pointer-events: none">Cannot Transfer</a></td></c:otherwise>
				     		</c:choose>
				     		
				     		<td><a href="transactionHistory?account_id=${loanAccount.id}&accountType=loan">View</a></td>
				     		<td><c:out value="${loanAccount.id}" /></td>
							<td><c:out value="${loanAccount.accountBalance}" /></td>
							<td><c:out value="${loanAccount.owedAmount}" /></td>
							<td><c:out value="${loanAccount.increaseRate}" /></td>
							<td><c:out value="${loanAccount.increaseInterval}" /></td>
							<td><c:out value="${loanAccount.latePaymentPenalty}" /></td>
							<td><c:out value="${loanAccount.intervalRequiredPayment}" /></td>
							<td><c:out value="${loanAccount.currentIntervalPaymentReceived}" /></td>
							<td><c:out value="${loanAccount.getLastIntervalDateAsString()}" /></td>
							<td><c:out value="${loanAccount.getDueDateAsString()}" /></td>
							<td><c:out value="${loanAccount.getCreationDateAsString()}" /></td>
							<td><c:out value="${loanAccount.validAccount}" /></td>
							<td><c:out value="${loanAccount.activatedAccount}" /></td>
							
							<c:choose>
				     			<c:when test="${loanAccount.owedAmount > 0}"><td><a href="payAccount?dueDate=&iRP=${loanAccount.intervalRequiredPayment}&account_id=${loanAccount.id}&owedAmount=${loanAccount.owedAmount}&cIPR=${loanAccount.currentIntervalPaymentReceived}&loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>">Pay Off</a></td></c:when>
				     			<c:otherwise><td><a style="pointer-events: none">All Paid</a></td></c:otherwise>
				     		</c:choose>
				     		
							<c:choose>
				     			<c:when test="${loanAccount.owedAmount <= 0 && loanAccount.accountBalance <= 0}"><td><a href="closeAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>&close_ID=${loanAccount.id}&close_Type=loan">Close</a></td></c:when>
				     			<c:otherwise><td><a style="pointer-events: none">Cannot Close</a></td></c:otherwise>
				     		</c:choose>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<a href="createLoanAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>">Request a new Loan Account?</a>
     		</c:when>
     		<c:otherwise>
     			<p>There are no Loan Accounts or an account has not been activated yet. Create a new account or wait for a banker to activate your account. Please visit a GoComBank branch to expedite this process.<br><a href="createLoanAccount?loginName=<%=request.getAttribute("loginName") %>&customer_id=<%= request.getAttribute("customer_id") %>">Request a new Loan Account?</a></p>
     		</c:otherwise>
     	</c:choose>     	
	</div>
  </body>
</html>