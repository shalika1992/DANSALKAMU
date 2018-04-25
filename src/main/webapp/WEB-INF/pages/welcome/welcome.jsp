<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>IBS</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/logo/logo.png" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href="${pageContext.request.contextPath}/resources/css/welcome.css"
	rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background-image: url("resources/img/logo/welcomePage.png");
}

#a_block_two {
	background: rgba(255, 175, 75, 1);
	background-image: url("resources/img/welcomePage/a4.png");
	background-repeat: no-repeat;
	background-size: contain;
	background-position: center;
}
</style>



</head>

<!--    <body class="w3-light-grey"> -->
<body>
	<div class="w3-container">
		<h2 class="w3-center">Internet Banking System</h2>


		<div class="w3-row  w3-center" style="width: 40%; margin: auto;">
			<div class="w3-col  l6 m6 s6">
				<a href="loadRegistrationPage.html">Sign UP</a>
			</div>
			<div class="w3-col  l6 m6 s6">
				<a href="loadLogin.html">Login</a>
			</div>
		</div>


		<div class="w3-row" id="a_block">
			<div id="a_block_one" class="w3-col    m2 w3-center"
				style="height: 200px"></div>
			<div id="a_block_two" class="w3-col s6 m2  w3-center"
				style="height: 200px"></div>
			<div id="a_block_three" class="w3-col s6 m2 w3-light-grey w3-center"
				style="height: 200px"></div>
			<div id="a_block_four" class="w3-col s6 m2 w3-dark-grey w3-center"
				style="height: 200px"></div>
			<div id="a_block_five" class="w3-col s6 m2 w3-light-grey w3-center"
				style="height: 200px"></div>
			<div id="a_block_six " class="w3-col    m2 w3-center"
				style="height: 200px"></div>
		</div>
		<div class="w3-row" id="b_block">
			<div class="w3-col    m2 w3-center" style="height: 200px"></div>
			<div class="w3-col s6 m2 w3-light-grey w3-center"
				style="height: 200px"></div>
			<div class="w3-col s6 m2 w3-dark-grey w3-center"
				style="height: 200px"></div>
			<div class="w3-col s6 m2 w3-light-grey w3-center"
				style="height: 200px"></div>
			<div class="w3-col s6 m2 w3-dark-grey w3-center"
				style="height: 200px"></div>
			<div class="w3-col    m2 w3-center" style="height: 200px"></div>
		</div>
	</div>


</body>
</html>
