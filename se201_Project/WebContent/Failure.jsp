<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	form{
		width: fit-content;
		text-align: center;
		margin-top: 30px;
	}
</style>
</head>
<body>
	<h1>
		<%=request.getAttribute("failureMessage") %>
	</h1>
</body>
</html>