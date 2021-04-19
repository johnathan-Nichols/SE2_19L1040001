<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %>
<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");/*format you want*/ String date = sdf.format(new Date());%>
<!DOCTYPE html>
<html>
	<head> 
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="SignUpAdmin">
	    <meta name="author" content="Johnathan M. Nichols">
	    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">
	
	    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">
	
	    <!-- Bootstrap core CSS -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	    
		<meta charset="ISO-8859-1">
		<title>Admin Sign Up Form</title> 
		<style> 
			html,	body {
			  height: 130%;
			}
			
			body {
			  display: -ms-flexbox;
			  display: -webkit-box;
			  display: flex;
			  -ms-flex-align: center;
			  -ms-flex-pack: center;
			  -webkit-box-align: center;
			  align-items: center;
			  -webkit-box-pack: center;
			  justify-content: center;
			  padding-top: 40px;
			  padding-bottom: 40px;
			  background-color: #f5f5f5;
			}
			
			.form-signin {
			  width: 100%;
			  max-width: 330px;
			  padding: 15px;
			  margin: 0 auto;
			}
			.form-signin .checkbox {
			  font-weight: 400;
			}
			.form-signin .form-control {
			  position: relative;
			  box-sizing: border-box;
			  height: auto;
			  padding: 10px;
			  font-size: 16px;
			}
			.form-signin .form-control:focus {
			  z-index: 2;
			}
			.form-signin input[type="email"] {
			  margin-bottom: -1px;
			  border-bottom-right-radius: 0;
			  border-bottom-left-radius: 0;
			}
			.form-signin input[type="password"] {
			  margin-bottom: 10px;
			  border-top-left-radius: 0;
			  border-top-right-radius: 0;
			}
		</style>
	</head>
	<body class="text-center">     
		<form class="form-signin" action="verifySignUpAdmin">
			<img class="mb-4 " src="https://github.com/johnathan-Nichols/SE2_19L1040001/blob/main/images/Globe.png?raw=true" alt="" width="72" height="72">
		 	
		 	<h1 class="h3 mb-3 font-weight-normal">Admin Sign Up Form</h1>
			
			<input class="form-control" type="text" name="Login Name" size="20" placeholder="Username" required>
			
			<input class="form-control" type="text" name="Login Password" size="20" placeholder="Password" required>
			
			<input class="form-control" type="text" name="First Name" size="20" placeholder="First Name" required>
			
			<input class="form-control" type="text" name="Middle Name" size="20" placeholder="Middle Name" required>
			
			<input class="form-control" type="text" name="Last Name" size="20" placeholder="Last Name" required>
			
			<input class="form-control" type="text" name="Identification Type" size="20" placeholder="identification type(I.E. Drivers License or Passport)" required>
			
			<input class="form-control" type="text" name="Identification Code" size="20" placeholder="identification code" required>
			
			<br><p>Date of Birth<input class="form-control" type="date" id="start" name="Date Of Birth" min="1900-01-01" max="<%=date%>" required></p><br>
			
			<input class="form-control" type="text" name="security question" size="50" placeholder="security question" required>
			
			<input class="form-control" type="text" name="security answer" size="50" placeholder="security answer" required><br><br>
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="Sign Up"> 
		</form>
	</body>
</html>