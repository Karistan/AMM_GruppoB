<%-- 
    Document   : vendi
    Created on : 14-lug-2016, 17.24.11
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendi</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="compere online, collezionismo">
        <meta name="description" content="Pagina dove confermare la vendita">
        <meta name="author" content="Kristian Niccolo' Paderi">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
        <body>
        <h3>${nome}</h3>
        <p>
        <div><img src="${immagine}" width="100" height="150"></div>
        <div>Descrizione: ${descrizione}</div>
        <div>Pezzi Disponibili: ${pezzi}</div>
        <div>Prezzo: ${prezzo/100} $</div>
        </p>
        <div>
            <form method="get" action="Venditore">
                <input type="hidden" name="nome" value="${nome}">
                <input type="hidden" name="immagine" value="${immagine}">
                <input type="hidden" name="descrizione" value="${descrizione}">
                <input type="hidden" name="pezzi" value="${pezzi}">
                <input type="hidden" name="prezzo" value="${prezzo}">
                <div id="submitbutton">
                    <input type="submit" name="ConfermaVendita" value="Conferma Vendita">
                </div>
            </form>
        </div>
    </body>
</html>
