<%-- 
    Document   : tabellavendi
    Created on : 28-lug-2016, 15.25.58
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
        <table>
            <tr>
                <th>Nome</th>
                <th>Immagine</th>
                <th>Pezzi</th>
                <th>Prezzo</th>
                <th>Edit</th>
            </tr>
            <c:if test="${oggetto.size()<1}"><tr>
                <td>Nessun oggetto in vendita.</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                </tr>
            </c:if>
            <c:if test="${oggetto.size()>=1}">
                <c:forEach items="${oggetto}" var="item">
                    <tr>
                        <td>${item.nome}</td>
                        <td><img src="${item.immagine}" height="90"></td>
                        <td>${item.getPezzi()}</td>
                        <td>${item.getPrezzo()/100} $</td>
                        <td>
                            <form method="get" action="Venditore">
                                <input type="hidden" name="idOggetto" value="${item.getId()}" />
                                <input type="submit" name="Modifica" value="Modifica">
                                <input type="submit" name="Cancella" value="Cancella">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>