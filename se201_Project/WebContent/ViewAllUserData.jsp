<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");/*format you want*/ String date = sdf.format(new Date());%>

<html>
<head>
  <title>User Management</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body>
  <div class="container"> <br>
  <p>Logged in as <%=request.getAttribute("adminLoginName") %>. adminEditID <%=request.getAttribute("adminEditID") %><a href="login">Log Out</a></p>
    <h3 class="text-center"><a href="">Home</a><br>USER LIST</h3> <br>
    <table class="table table-bordered table-striped">
      <thead>
        <tr>
          <th>Edit</th>
          <th>Delete</th>
          <th>ID</th>
          <th>Last Name</th>
          <th>Middle Name</th>
          <th>First Name</th>
          <th>DOB</th>
          <th>ID Type</th>
          <th>ID Code</th>
          <th>Login Name</th>
          <th>Login Password</th>
          <th>Valid User</th>
          <th>Activated User</th>
          <th>Activation Date</th>
          <th>User Type</th>
          <th>Security Question</th>
          <th>Security Answer</th>
        </tr>
      </thead>      
      <tbody>
      <c:forEach var="users" items="${users}">
        <tr>
          <td><a href="editUser?user_id=<c:out value='${users.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Edit</a></td>
          <td><a href="deleteUser?user_id=<c:out value='${users.id}' />&userType=<c:out value='${users.userType}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Delete</a></td>
          <td><c:out value="${users.id}" /></td>
          <td><c:out value="${users.lastName}" /></td>
          <td><c:out value="${users.middleName}" /></td>
          <td><c:out value="${users.firstName}" /></td>
          <td><c:out value="${users.dob}" /></td>
          <td><c:out value="${users.idType}" /></td>
          <td><c:out value="${users.idCode}" /></td>
          <td><c:out value="${users.loginName}" /></td>
          <td><c:out value="${users.loginPassword}" /></td>
          <td><c:out value="${users.validUser}" /><br><a href="validateUser?user_id=<c:out value='${users.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Validate</a><br><a href="invalidateUser?user_id=<c:out value='${users.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Invalidate</a></td>
          <td><c:out value="${users.activatedUser}" /><br><a href="activateUser?user_id=<c:out value='${users.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Activate</a><br><a href="deactivateUser?user_id=<c:out value='${users.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Deactivate</a></td>
          <td><c:out value="${users.activationDate}" /></td>
          <td><c:out value="${users.userType}" /></td>
          <td><c:out value="${users.securityQuestion}" /></td>
          <td><c:out value="${users.securityAnswer}" /></td>
        </tr>
	</c:forEach>
    </tbody>
    </table> <br>
    <h3 class="text-center">ADMIN LIST<br><a href="signUpAdmin">Add an Admin</a></h3> <br>
    <table class="table table-bordered table-striped">
      <thead>
        <tr>
          <th>Edit</th>
          <th>Delete</th>
          <th>Admin ID</th>
          <th>User ID</th>
          <th>Last Name</th>
          <th>Middle Name</th>
          <th>First Name</th>
          <th>DOB</th>
          <th>ID Type</th>
          <th>ID Code</th>
          <th>Login Name</th>
          <th>Login Password</th>
          <th>Valid User</th>
          <th>Activated User</th>
          <th>Activation Date</th>
          <th>User Type</th>
          <th>Security Question</th>
          <th>Security Answer</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="admins" items="${admins}">
        <tr>
          <td><a href="editAdmin?user_id=<c:out value='${admins.user.id}' />&admin_id=<c:out value='${admins.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Edit</a></td>
          <td><a href="deleteUser?user_id=<c:out value='${admins.user.id}' />&userType=<c:out value='${admins.user.userType}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Delete</a></td>
          <td><c:out value="${admins.id}" /></td>
          <td><c:out value="${admins.user.id}" /></td>
          <td><c:out value="${admins.user.lastName}" /></td>
          <td><c:out value="${admins.user.middleName}" /></td>
          <td><c:out value="${admins.user.firstName}" /></td>
          <td><c:out value="${admins.user.dob}" /></td>
          <td><c:out value="${admins.user.idType}" /></td>
          <td><c:out value="${admins.user.idCode}" /></td>
          <td><c:out value="${admins.user.loginName}" /></td>
          <td><c:out value="${admins.user.loginPassword}" /></td>
          <td><c:out value="${admins.user.validUser}" /><br><a href="validateUser?user_id=<c:out value='${admins.user.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Validate</a><br><a href="invalidateUser?user_id=<c:out value='${admins.user.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Invalidate</a></td>
          <td><c:out value="${admins.user.activatedUser}" /><br><a href="activateUser?user_id=<c:out value='${admins.user.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Activate</a><br><a href="deactivateUser?user_id=<c:out value='${admins.user.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Deactivate</a></td>
          <td><c:out value="${admins.user.activationDate}" /></td>
          <td><c:out value="${admins.user.userType}" /></td>
          <td><c:out value="${admins.user.securityQuestion}" /></td>
          <td><c:out value="${admins.user.securityAnswer}" /></td>
        </tr>
	</c:forEach>
      </tbody>
    </table> <br>
    <h3 class="text-center">CUSTOMER LIST</h3> <br>
    <table class="table table-bordered table-striped">
      <thead>
        <tr>
          <th>Edit</th>
          <th>Delete</th>
          <th>ID</th>
          <th>Position In Company</th>
          <th>Employer</th>
          <th>Nationality</th>
          <th>House Number</th>
          <th>Street Name</th>
          <th>City Name</th>
          <th>State Name</th>
          <th>Country Name</th>
          <th>Postal Code</th>
          <th>Activation Date</th>
          <th>User ID</th>
          <th>Last Name</th>
          <th>Middle Name</th>
          <th>First Name</th>
          <th>DOB</th>
          <th>ID Type</th>
          <th>ID Code</th>
          <th>Login Name</th>
          <th>Login Password</th>
          <th>Valid User</th>
          <th>Activated User</th>
          <th>User Type</th>
          <th>Security Question</th>
          <th>Security Answer</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="customers" items="${customers}">
        <tr>
          <td><a href="editCustomer?user_id=<c:out value='${customers.user.id}' />&customer_id=<c:out value='${customers.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Edit</a></td>
          <td><a href="deleteUser?user_id=<c:out value='${customers.user.id}' />&userType=<c:out value='${customers.user.userType}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Delete</a></td>
          <td><c:out value="${customers.id}" /></td>
          <td><c:out value="${customers.positionInCompany}" /></td>
          <td><c:out value="${customers.employer}" /></td>
          <td><c:out value="${customers.nationality}" /></td>
          <td><c:out value="${customers.houseNumber}" /></td>
          <td><c:out value="${customers.streetName}" /></td>
          <td><c:out value="${customers.cityName}" /></td>
          <td><c:out value="${customers.stateName}" /></td>
          <td><c:out value="${customers.countryName}" /></td>
          <td><c:out value="${customers.postalCode}" /></td>
          <td><c:out value="${customers.user.activationDate}" /></td>
          <td><c:out value="${customers.user.id}" /></td>
          <td><c:out value="${customers.user.lastName}" /></td>
          <td><c:out value="${customers.user.middleName}" /></td>
          <td><c:out value="${customers.user.firstName}" /></td>
          <td><c:out value="${customers.user.dob}" /></td>
          <td><c:out value="${customers.user.idType}" /></td>
          <td><c:out value="${customers.user.idCode}" /></td>
          <td><c:out value="${customers.user.loginName}" /></td>
          <td><c:out value="${customers.user.loginPassword}" /></td>
          <td><c:out value="${customers.user.validUser}" /><br><a href="validateUser?user_id=<c:out value='${customers.user.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Validate</a><br><a href="invalidateUser?user_id=<c:out value='${customers.user.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Invalidate</a></td>
          <td><c:out value="${customers.user.activatedUser}" /><br><a href="activateUser?user_id=<c:out value='${customers.user.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Activate</a><br><a href="deactivateUser?user_id=<c:out value='${customers.user.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Deactivate</a></td>
          <td><c:out value="${customers.user.userType}" /></td>
          <td><c:out value="${customers.user.securityQuestion}" /></td>
          <td><c:out value="${customers.user.securityAnswer}" /></td>
        </tr>
	</c:forEach>
      </tbody>
    </table>
    
		<h3 class="text-center">Checking Account</h3>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>View Account History</th>
					<th>Customer ID</th>
					<th>ID</th>
					<th>accountBalance</th>
					<th>creationDate</th>
					<th>validAccount</th>
					<th>activatedAccount</th>
				</tr>
			</thead>
			<tbody>
	      		<c:forEach var="checkingAccount" items="${checkingAccounts}">
				<tr>
		     		<td><a href="view?account_id=${checkingAccount.id}&accountType=checking">View</a></td>
					<td><c:out value="${checkingAccount.getCustomer().getId()}" /></td>
					<td><c:out value="${checkingAccount.id}" /></td>
					<td><c:out value="${checkingAccount.accountBalance}" /></td>
					<td><c:out value="${checkingAccount.getCreationDate()}" /></td>
					<td><c:out value="${checkingAccount.validAccount}" /><a href="setValidAccount?accountType=checking&account_id=<c:out value='${checkingAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Validate</a><br><a href="setInvalidAccount?accountType=checking&account_id=<c:out value='${checkingAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Invalidate</a></td>
					<td><c:out value="${checkingAccount.activatedAccount}" /><a href="setActiveAccount?accountType=checking&account_id=<c:out value='${checkingAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Activate</a><br><a href="setDeactiveAccount?accountType=checking&account_id=<c:out value='${checkingAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Deactivate</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
    	
   		<h3 class="text-center">Savings Account</h3>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>View Account History</th>
					<th>Customer ID</th>
					<th>ID</th>
					<th>accountBalance</th>
					<th>increasePercentage</th>
					<th>increaseRate</th>
					<th>lastIncrease</th>
					<th>creationDate</th>
					<th>validAccount</th>
					<th>activatedAccount</th>
				</tr>
			</thead>
			<tbody>
	      		<c:forEach var="savingsAccount" items="${savingsAccounts}">
				<tr>
		     		<td><a href="view?account_id=${savingsAccount.id}&accountType=<%=request.getAttribute("accountType") %>">View</a></td>
					<td><c:out value="${savingsAccount.getCustomer().getId()}" /></td>
		     		<td><c:out value="${savingsAccount.id}" /></td>
					<td><c:out value="${savingsAccount.accountBalance}" /></td>
					<td><c:out value="${savingsAccount.increasePercentage}" /></td>
					<td><c:out value="${savingsAccount.increaseRate}" /></td>
					<td><c:out value="${savingsAccount.getLastIncrease()}" /></td>
					<td><c:out value="${savingsAccount.getCreationDate()}" /></td>
					<td><c:out value="${savingsAccount.validAccount}" /><a href="setValidAccount?accountType=savings&account_id=<c:out value='${savingsAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Validate</a><br><a href="setInvalidAccount?accountType=savings&account_id=<c:out value='${savingsAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Invalidate</a></td>
					<td><c:out value="${savingsAccount.activatedAccount}" /><a href="setActiveAccount?accountType=savings&account_id=<c:out value='${savingsAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Activate</a><br><a href="setDeactiveAccount?accountType=savings&account_id=<c:out value='${savingsAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Deactivate</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
     	
   		<h3 class="text-center">Loan Account</h3>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
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
				</tr>
			</thead>
			<tbody>
     			<c:forEach var="loanAccount" items="${loanAccounts}">
				<tr>		     		
		     		<td><a href="view?account_id=${loanAccount.id}&accountType=loan">View</a></td>
					<td><c:out value="${loanAccount.getCustomer().getId()}" /></td>
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
					<td><c:out value="${loanAccount.validAccount}" /><a href="setValidAccount?accountType=loan&account_id=<c:out value='${loanAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Validate</a><br><a href="setInvalidAccount?accountType=loan&account_id=<c:out value='${loanAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Invalidate</a></td>
					<td><c:out value="${loanAccount.activatedAccount}" /><a href="setActiveAccount?accountType=loanAccount&account_id=<c:out value='${loanAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Activate</a><br><a href="setDeactiveAccount?accountType=loan&account_id=<c:out value='${loanAccount.id}' />&adminEditID=<%=request.getAttribute("adminEditID") %>&adminLoginName=<%=request.getAttribute("adminLoginName") %>">Deactivate</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>  
  	</div>
</body>

</html>
