<%-- 
    Document   : tabellacomprajson
    Created on : 31-lug-2016, 17.38.39
    Author     : User
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="item" items="${lista}">
        <json:object>
            <json:property name="id" value="${item.id}"/>
            <json:property name="nome" value="${item.nome}"/>
            <json:property name="immagine" value="${item.immagine}"/>
            <json:property name="descrizione" value="${item.descrizione}"/>
            <json:property name="pezzi" value="${item.pezzi}"/>
            <json:property name="prezzo" value="${item.prezzo}"/>
        </json:object>
    </c:forEach>
</json:array>
