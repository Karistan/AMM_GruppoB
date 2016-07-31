<%-- 
    Document   : tabellacompa
    Created on : 13-lug-2016, 19.40.24
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table id="tabellacompra">
            <tr>
                <th>Nome</th>
                <th>Immagine</th>
                <th>Pezzi</th>
                <th>Prezzo</th>
                <th>Compra</th>
            </tr>
            <c:forEach items="${oggetto}" var="item">
                <tr>
                    <td>${item.nome}</td>
                    <td><img src="${item.immagine}" height="90"></td>
                    <td>${item.pezzi}</td>
                    <td>${(item.prezzo/100)} $</td>
                    <td>
                        <form method="get" action="Cliente">
                            <input type="hidden" name="idOggetto" value="${item.getId()}" />
                            <input type="submit" name="Compra" value="Compra">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
