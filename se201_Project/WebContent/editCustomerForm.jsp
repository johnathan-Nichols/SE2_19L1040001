<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");/*format you want*/ String date = sdf.format(new Date());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
		<form action="verifyEditCustomer"> 
			<fieldset>
				Enter the username: 
				<input type="text" name="loginName" size="20"><br><br>
				Enter the password: 
				<input type="text" name="loginPassword" size="20"><br><br>
				Enter the first name: 
				<input type="text" name="firstName" size="20"><br><br>
				Enter the middle name: 
				<input type="text" name="middleName" size="20"><br><br>
				Enter the last name: 
				<input type="text" name="lastName" size="20"><br><br>
				Enter the identification type(I.E. Drivers License or Passport): 
				<input type="text" name="idType" size="20"><br><br>
				Enter the identification code: 
				<input type="text" name="idCode" size="20"><br><br>
				Enter the date of birth:
				<input type="date" id="start" name="dob" min="1900-01-01" max="<%=date%>"><br><br>
				Enter the user Type: 
				<input type="text" name="userType" size="20"><br><br>
				Validate User enter /"True/" or /"False/": 
				<input type="text" name="validateUser" size="5"><br><br>
				Activate User enter /"True/" or /"False/": 
				<input type="text" name="activatedUser" size="5"><br><br>
				Enter the position in the company: 
				<input type="text" name="positionInCompany" size="20"><br><br>
				Enter the employer: 
				<input type="text" name="employer" size="20"><br><br>
				Enter the nationality: 
				<input type="text" name="nationality" size="20"><br><br>
				Enter the house number: 
				<input type="text" name="houseNumber" size="20"><br><br>
				Enter the street name: 
				<input type="text" name="streetName" size="20"><br><br>
				Enter the city name: 
				<input type="text" name="cityName" size="20"><br><br>
				Enter the state name: 
				<input type="text" name="stateName" size="20"><br><br>
				Enter the country name: 
				<input type="text" name="countryName" size="20"><br><br>
				Enter the postal code: 
				<input type="text" name="postalCode" size="20"><br><br>
				Enter your security question: 
				<input type="text" name="security question" size="50"><br><br>
				Enter your security answer: 
				<input type="text" name="security answer" size="50"><br><br>
				<input type="hidden" id="user_id" name="user_id" value=<%=request.getParameter("user_id") %>>
				<input type="hidden" id="adminEditID" name="adminEditID" value=<%=request.getParameter("adminEditID") %>>
				<input type="hidden" id="adminLoginName" name="adminLoginName" value=<%=request.getParameter("adminLoginName") %>>
				<input type="submit" value="Edit"> 
			</fieldset> 
		</form>
</body>
</html>