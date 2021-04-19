<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3 class="text-center">Transaction History</h3>
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>accountID</th>
				<th>acountType</th>
				<th>transactionDate</th>
				<th>amount</th>
			</tr>
		</thead>
		<tbody>
      		<c:forEach var="transactionHistory" items="${transactionHistories}">
			<tr>
				<td><c:out value="${transactionHistory.accountID}" /></td>
				<td><c:out value="${transactionHistory.acountType}" /></td>
				<td><c:out value="${transactionHistory.transactionDate}" /></td>
				<td><c:out value="${transactionHistory.amount}" /></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>