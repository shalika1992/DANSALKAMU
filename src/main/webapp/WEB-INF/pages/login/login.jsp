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
                <div id="id01" class="w3-modal w3-transparent">

                    <div class="w3-modal-content w3-animate-top w3-card-4 w3-transparent">
                        <header class="w3-container">
                            <span onclick="hideRegistrationForm()" class="w3-button w3-display-topright">&times;</span>

                            <div class="w3-row">
                                <div>
                                    <img src="${pageContext.request.contextPath}/resources/img/logo/logo.png" style="width:5%" class="w3-round" alt="Norway">
                                    <h2>Registration</h2>
                                </div>
                            </div>
                        </header>
                        <div class="w3-container">
                            <form:form method="POST" class="w3-container  w3-transparent" action="">

                                <div class="w3-row">
                                    <form:input placeholder="User Name" class="w3-input w3-border w3-round" path="userName" type="text" />
                                    <br/>
                                </div>
                                <div class="w3-row">
                                    <form:input placeholder="Password" class="w3-input w3-border w3-round-large" path="password" type="text" />
                                </div>
                                <div class="w3-row">
                                    <div class="s6 w3-left-align">
                                        <input type="submit" class="w3-button w3-black" value="Register">
                                    </div>
                                    <div class="s6 w3-right-align">
                                        <input onclick="hideRegistrationForm()" type="button" class="w3-button w3-black" value="Cancel">
                                    </div>
                                </div>
                                <br/>
                            </form:form>
                        </div>
                        <footer class="w3-container ">
                            <p>Modal Footer</p>
                        </footer>
                    </div>
                </div>
    

        </body>

        <script type="text/javascript">
            function showRegistrationForm() {
                document.getElementById('id01').style.display = 'block';
                document.getElementById('loginForm').style.display = 'none';
                document.getElementById('footer').style.display = 'none';

            }

            function hideRegistrationForm() {
                document.getElementById('id01').style.display = 'none';
                document.getElementById('loginForm').style.display = 'block';
                document.getElementById('footer').style.display = 'block';
            }
        </script>

        </html>