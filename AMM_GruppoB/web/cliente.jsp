<%-- 
    Document   : cliente
    Created on : 12-lug-2016, 18.42.54
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Area Clienti</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="M1, cliente, compere online, collezionismo">
        <meta name="description" content="La pagina dove i clienti possono comprare
              opere di collezione">
        <meta name="author" content="Kristian Niccolo' Paderi">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src="js/filter.js"></script>
        <script type="text/javascript" src="js/jquery-3.1.0.min.js"></script>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="rightsidebar.jsp"/>
        <div class="content">
            <c:if test="${Messaggio != null}">
                ${Messaggio}
            </c:if>
            <c:choose>
                <c:when test="${flag=='Compra'}">
                    <jsp:include page="compra.jsp"/>
                </c:when>
                <c:when test="${flag=='Home'}">
                    <form>
                        <label for="filter">Filtra: </label>
                        <input type="text" id="filter" size="20" onkeyup="filtra(event)"/>
                    </form>
                    <jsp:include page="tabellacompra.jsp"/>
                </c:when>
            </c:choose>
        </div>
        <jsp:include page="footer.jsp"/>
        
    </body>
</html>
