<%-- 
    Document   : aggiunta
    Created on : 30-lug-2016, 18.44.04
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
        <h2>Form Aggiunta</h2>
                <form method="POST" action="Venditore">
                    <span>
                        <label for="nome">Nome</label>
                        <input type="text" name="nome">
                    </span>
                    <span>
                        <label for="img">Immagine</label>
                        <input type="text" name="immagine">
                    </span>
                    <span>
                        <label for="descrizione" >Descrizione oggetto:</label>                  
                        <textarea name="descrizione" rows="4" cols="20"></textarea>
                    </span>
                    <span>
                        <label for="prezzo">Prezzo:</label>
                        <input type="number" name="prezzo"/>
                    </span>
                    <span>
                        <label for="pezzi">Pezzi:</label>
                        <input type="number" name="pezzi"/>
                    </span>
                    <span>
                        <div id="submitbutton">
                            <input type="submit" name="Vendi" value="Invia" class="button">
                        </div>
                    </span>
                </form>
    </body>
</html>
