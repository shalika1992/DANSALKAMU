<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@taglib uri="http://www.springframework.org/tags/form" prefix = "form"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <title>IBS</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

        <body>

            <div class="w3-row w3-row-padding" id="loginForm">
                <div class="w3-col  l8 m8 s12  w3-center" style="hight:100%">
                    <p>..</p>
                </div>
                <div class="w3-col  l4 m4 s12  w3-center" style="hight:100%" >
                    <form:form method="POST" class="w3-container  w3-light-grey" action="login.html">
                        <br/>
                        <div class="w3-row">
                            <img src="${pageContext.request.contextPath}/resources/img/logo/logo.png" style="width:20%" class="w3-round" alt="Norway">
                        </div>
                        <br/>
                        <div class="w3-row">
                            <form:input placeholder="User Name" class="w3-input w3-border w3-round" path="userName" type="text" />
                            <br/>
                        </div>
                        <div class="w3-row">
                            <form:input placeholder="Password" class="w3-input w3-border w3-round-large" path="password" type="text" />
                        </div>
                        <div class="w3-row">
                            <div class="s8 w3-left-align">forgot password?</div>
                            <div class="s4 w3-right-align">
                                <input type="submit" class="w3-button w3-black" value="Sign In">
                            </div>
                        </div>
                        <br/>
                    </form:form>

                    <a href="#" onclick="showRegistrationForm()">Register</a>
                </div>
                </div>
        
    

        </body>




        </html>