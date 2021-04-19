<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Login">
    <meta name="author" content="Johnathan M. Nichols">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    
	<meta charset="ISO-8859-1">
	<title>User Login</title>
	<style>
		html,	body {
		  height: 100%;
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
	<!-- Once we submit this form it will send us to the VerifyLoginServlet -->
	
	<form class="form-signin" action="verifyLogin">
      
      <img class="mb-4" src="https://github.com/johnathan-Nichols/SE2_19L1040001/blob/main/images/Globe.png?raw=true" alt="" width="72" height="72">
      
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      
      <label for="inputEmail" class="sr-only">Enter your username:</label>
      <input type="text" name="Login Name" id="Login Name" class="form-control" placeholder="Username" required autofocus>
      
      <label for="inputPassword" class="sr-only">Enter your password:</label>
      <input type="password" name="Login Password" id="Login Password" class="form-control" placeholder="Password" required>
      
      <div class="checkbox mb-3">
        <label>
			<a href="signUp">Create New Account</a><br>
			<a href="resetPassword">Reset Password</a>
        </label>
      </div>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      
      <p class="mt-5 mb-3 text-muted">&copy; 2007-2021</p>
    
    </form>
</body>
</html>