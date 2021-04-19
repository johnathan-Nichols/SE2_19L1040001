<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>View History</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body>
	<h3 class="text-center">Account History</h3>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>accountID</th>
					<th>accountType</th>
					<th>TransactionDate</th>
					<th>amount</th>
					<th>receivingID</th>
					<th>receivingType</th>
				</tr>
			</thead>
			<tbody>
     			<c:forEach var="history" items="${history}">
				<tr>		     		
		     		<td><c:out value="${history.getId()}" /></td>
		     		<td><c:out value="${history.getAccountID()}" /></td>
		     		<td><c:out value="${history.getAcountType()}" /></td>
		     		<td><c:out value="${history.getTransactionDateAsString()}" /></td>
		     		<td><c:out value="${history.getAmount()}" /></td>
		     		<td><c:out value="${history.getReceivingID()}" /></td>
		     		<td><c:out value="${history.getReceivingType()}" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>  
</body>
</html>