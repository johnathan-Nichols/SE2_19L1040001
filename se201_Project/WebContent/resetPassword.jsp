<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
	<h3 class="text-center">Reset Password</h3>
	<!-- Once we submit this form it will send us to the VerifyLoginServlet -->
	<form action="verifyResetPassword">
		<fieldset>
			<h5>Enter the new password</h5><br><br>
			<input type="text" name="loginPassword" size="50" required="required"><br><br>
			<input type="submit" value="Reset Password">
		</fieldset>
	</form>
</body>
</html>