<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Answer Security Question</title>
</head>
<body>
	<h3 class="text-center">Reset Password</h3>
	<!-- Once we submit this form it will send us to the VerifyLoginServlet -->
	<form action="verifyAnswerSecurityQuestion">
		<fieldset>
			<h5><%=request.getAttribute("securityQuestion") %></h5><br><br>
			Enter your answer:
			<input type="text" name="securityAnswer" size="50" required="required"><br><br>
			<input type="submit" value="Reset Password">
		</fieldset>
	</form>
</body>
</html>