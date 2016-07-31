<%-- 
    Document   : modifica
    Created on : 29-lug-2016, 17.40.28
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
        <h2>Form Modifica</h2>
        <form method="POST" action="Venditore">
            <span>
                <label for="nome">Nome</label>
                <input type="text" name="nome" value="${oggetto.nome}">
            </span>
            <span>
                <label for="img">Immagine</label>
                <input type="text" name="immagine" value="${oggetto.immagine}">
            </span>
            <span>
                <label for="descrizione" >Descrizione oggetto:</label>                  
                <textarea name="descrizione" rows="4" cols="20">${oggetto.descrizione}</textarea>
            </span>
            <span>
                <label for="prezzo">Prezzo:</label>
                <input type="number" name="prezzo" value="${oggetto.prezzo}"/>
            </span>
            <span>
                <label for="pezzi">Pezzi:</label>
                <input type="number" name="pezzi" value="${oggetto.pezzi}"/>
            </span>
            <span>
                <input type="hidden" name="idOggetto" value="${oggetto.id}">
                <div id="submitbutton">
                    <input type="submit" name="ConfermaModifica" value="Invia" class="button">
                </div>
            </span>
        </form>
    </body>
</html>
