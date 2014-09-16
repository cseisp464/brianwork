<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome to Homework Airlines</title>
	</head>

	<body>
		<center>
			<h1> Welcome to Homework Airlines!</h1>
		
			<strong><h2>Sign In:</h2></strong>
			<form action="/LoginPage" method = post>
			<table border = 1>
			Username:<input type = "text" name = "username">
			Password:<input type = "password" name = "password">
			<input type = "submit" value = "Submit">
			</table>
			<br/><a href="RegistrationPage">Register as New User</a> 
			</form>
		</center>
		
		
	</body>
</html>