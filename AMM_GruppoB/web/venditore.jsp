<%-- 
    Document   : venditore
    Created on : 10-lug-2016, 18.22.07
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Area Venditori</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="M1, venditore, compere online, collezionismo">
        <meta name="description" content="L'area dove gli utenti venditori possono
              inserire le loro opere di collezione">
        <meta name="author" content="Kristian Niccolo' Paderi">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="rightsidebar.jsp"/>
        <div class="content">
            
            <c:if test="${Messaggio != null}">
                ${Messaggio}
            </c:if>
            <c:choose>
            <c:when test="${flag=='Home'}">
                <jsp:include page="aggiunta.jsp"/>
                <jsp:include page="tabellavendi.jsp"/>
            </c:when>
            <c:when test="${flag=='Vendi'}">
                <jsp:include page="vendi.jsp"/>
            </c:when>
            <c:when test="${flag=='Modifica'}">
                <jsp:include page="modifica.jsp"/>
            </c:when>
            <c:when test="${flag=='Cancella'}">
                <jsp:include page="cancella.jsp"/>
            </c:when></c:choose>
            
        </div>
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
