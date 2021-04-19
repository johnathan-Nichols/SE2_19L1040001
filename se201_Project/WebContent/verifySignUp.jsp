<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<body>
		<h2>Created <%=request.getParameter("Login Name")%>!</h2> 

	 	<form action="Login">
	 		<fieldset>
	 			Return to the login page:
	 			<input type="submit" value="Login">
	 		</fieldset>
	 	</form>
	 </body>
 </html>