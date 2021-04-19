<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");/*format you want*/ String date = sdf.format(new Date());%>
<!DOCTYPE html>
<html>
	<head> 
		<meta charset="ISO-8859-1"> 
		<title>Sign Up Form</title> 
		<style> form { width: fit-content; text-align: center; margin-top: 30px; } </style>
	</head>
	<body>
		<form action="verifySignUp"> 
			<fieldset>
				Enter your username: 
				<input type="text" name="Login Name" size="20" required="required"><br><br>
				Enter your password: 
				<input type="text" name="Login Password" size="20" required="required"><br><br>
				Enter your first name: 
				<input type="text" name="First Name" size="20" required="required"><br><br>
				Enter your middle name: 
				<input type="text" name="Middle Name" size="20" required="required"><br><br>
				Enter your last name: 
				<input type="text" name="Last Name" size="20" required="required"><br><br>
				Enter your identification type(I.E. Drivers License or Passport): 
				<input type="text" name="Identification Type" size="20" required="required"><br><br>
				Enter your identification code: 
				<input type="text" name="Identification Code" size="20" required="required"><br><br>
				Enter your date of birth (yyyy/mm/dd):
				<input type="date" id="start" name="Date Of Birth" min="1900-01-01" max="<%=date%>"><br><br>
				Enter your position in your company: 
				<input type="text" name="positionInCompany" size="20" required="required"><br><br>
				Enter your employer: 
				<input type="text" name="employer" size="20" required="required"><br><br>
				Enter your nationality: 
				<input type="text" name="nationality" size="20" required="required"><br><br>
				Enter your house number: 
				<input type="text" name="houseNumber" size="20" required="required"><br><br>
				Enter your street name: 
				<input type="text" name="streetName" size="20" required="required"><br><br>
				Enter your city name: 
				<input type="text" name="cityName" size="20" required="required"><br><br>
				Enter your state name: 
				<input type="text" name="stateName" size="20" required="required"><br><br>
				Enter your country name: 
				<input type="text" name="countryName" size="20" required="required"><br><br>
				Enter your postal code: 
				<input type="text" name="postalCode" size="20" required="required"><br><br>
				Enter your security question: 
				<input type="text" name="security question" size="50" required="required"><br><br>
				Enter your security answer: 
				<input type="text" name="security answer" size="50" required="required"><br><br>
				<input type="submit" value="Sign Up"> 
			</fieldset> 
		</form>
	</body>
</html>