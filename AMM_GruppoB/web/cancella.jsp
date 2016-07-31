<%-- 
    Document   : cancella
    Created on : 30-lug-2016, 18.13.00
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>${oggetto.nome}</h3>
        <p>
        <div><img src="${oggetto.immagine}" width="100" height="150"></div>
        <div>Descrizione: ${oggetto.descrizione}</div>
        <div>Pezzi Disponibili: ${oggetto.pezzi}</div>
        <div>Prezzo: ${oggetto.prezzo/100} $</div>
        </p>
        <div>
            <form method="get" action="Venditore">
                <input type="hidden" name="idOggetto" value="${oggetto.id}">
                <div id="submitbutton">
                    <input type="submit" name="ConfermaCancella" value="Rimuovi dalla lista">
                </div>
            </form>
        </div>
    </body>
</html>
