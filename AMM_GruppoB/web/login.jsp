<%-- 
    Document   : login
    Created on : 12-lug-2016, 18.38.41
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="login, compere online, collezionismo">
        <meta name="description" content="L'area del sito dove potersi connettere
              ai servizi">
        <meta name="author" content="Kristian Niccolo' Paderi">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="page">
           <jsp:include page="header.jsp"/>
           <jsp:include page="loginrightsidebar.jsp"/>
            <div class="content">
                <h2>Login</h2>
                <c:if test="${requestScope.Messaggio != null}">${requestScope.Messaggio}</c:if>
                <form method="get" action="Login">
                    <input type="hidden" name="hiddenField" value="loggedIn">
                    <span>
                        <label for="utente">Nome utente:</label>
                        <input type="text" name="Username" id="utente">
                    </span>
                    <span>
                        <label for="psw">Password:</label>
                        <input type="password" name="Password" id="psw"/>
                    </span>
                    <div id="submitbutton">
                        <input type="submit" name="Submit" value="Login" class="button">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
