<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>IBS</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" type="text/css" href="resources/css/login/login.css" />
</head>
<body>

	<div class="w3-row" id="login_form_main">
	  <div class="w3-col s2 m4 l4">
	    <p></p>
	  </div>
	  <div class="w3-col s8 m4 l4">
	   <div  id="login_form">
		<form:form method="POST" class="w3-container " action="login.html">
			<br />
			<div class="w3-row w3-center" >
				
			<img src="${pageContext.request.contextPath}/resources/img/logo/logo.png" style="width: 10%" class="w3-round" alt="Norway">
				<h4 class="text-center">Login Form</h4>
			</div>
			
		
			
			<hr/>
			
			<div class="w3-row">
				 <label >User Name:</label>
				<form:input placeholder="Enter Your User Name" class="w3-input w3-border w3-round" path="userName" type="text" />
				<br/>
			</div>
			
			<div class="w3-row">
				<label >Password:</label>
				<form:input placeholder=" Enter Your Password" class="w3-input w3-border w3-round-large" path="password" type="password" />
			</div>
			<hr/>
			
			<div class="w3-row  w3-center" >
				<div class="w3-col  l2 ">	
					<p></p>	
				</div>
				<div class="w3-col  l8 m12 s12">
					<input type="submit" class="w3-button w3-black" value="Sign In">
					<a href="index.jsp" class="w3-button w3-black">Cancle</a>
				</div>
			
				<div class="w3-col  l2  ">
					<p></p>
				</div>
			</div>
			
			<div class="w3-row w3-center">
				<div>forgot password?</div>
			</div>
			<br/>
		</form:form>
		<div class="w3-row w3-center">
		<a href="register.html" >Register</a>
		</div>
	</div>
	  </div>
	   <div class="w3-col s2 m4 l4">
	    <p></p>
	  </div>
	</div>














	
</body>
</html>