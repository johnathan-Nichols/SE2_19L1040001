<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>View Edits</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body>
	<h3 class="text-center">Database Edits</h3>
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>id</th>
					<th>editDate</th>
					<th>editor User ID</th>
					<th>edited User ID</th>
					<th>edit Description</th>
				</tr>
			</thead>
			<tbody>
     			<c:forEach var="edits" items="${edits}">
				<tr>		     		
		     		<td><c:out value="${edits.getId()}" /></td>
		     		<td><c:out value="${edits.getEditDateAsString()}" /></td>
		     		<td><c:out value="${edits.getEditerUserID()}" /></td>
		     		<td><c:out value="${edits.getEditedUserID()}" /></td>
		     		<td><c:out value="${edits.getEditDescription()}" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>  
</body>
</html>