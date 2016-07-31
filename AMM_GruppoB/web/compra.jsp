<%-- 
    Document   : compra.jsp
    Created on : 14-lug-2016, 11.20.54
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="compere online, collezionismo">
        <meta name="description" content="Pagina dove confermare la compera">
        <meta name="author" content="Kristian Niccolo' Paderi">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <h3>${OggettoScelto.nome}</h3>
        <p>
        <div><img src="${OggettoScelto.immagine}" width="100" height="150"></div>
        <div>Descrizione: ${OggettoScelto.descrizione}</div>
        <div>Pezzi Disponibili: ${OggettoScelto.pezzi}</div>
        <div>Prezzo: ${OggettoScelto.prezzo/100} $</div>
        <div>Credito disponibile: ${Credito/100} $</div>
        </p>
        <div>
            <form method="get" action="Cliente">
                <input type="hidden" name="idOggetto" value="${OggettoScelto.id}" />
                <input type="hidden" name="Prezzo" value="${OggettoScelto.prezzo}"/>
                <input type="submit" name="ConfermaAcquisto" value="Conferma acquisto">
            </form>
        </div>
    </body>
</html>
