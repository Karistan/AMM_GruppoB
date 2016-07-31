<%-- 
    Document   : Descrizione
    Created on : 9-lug-2016, 19.29.51
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Collezionisti d'anime</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="M1, descrizione, compere online, collezionismo">
        <meta name="description" content="La descrizione del sito dei Collezionisti d'anime">
        <meta name="author" content="Kristian Niccolo' Paderi">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
       <div class="columstriple">
           <jsp:include page="header.jsp"/>
           <jsp:include page="leftsidebar.jsp"/>
           <jsp:include page="rightsidebar.jsp"/>
        <div class="content">
            
            
            <h1 id="collezionisti">Collezionisti d'anime</h1>
            <p>Il sito dei Collezionisti d'anime permette con facilità di potersi
            registrare e facilitare la compravendita di oggetti di collezionismo
            di vari generi: semplice e veloce, sarà possibile registrare degli
            oggetti come venditori e comprarne degli altri come clienti. Gli articoli
            presenti qua devono essere trattati con cura ed essere in perfette condizioni,
            tali da garantirne l'utilizzo come se fossero stati comprati al negozio.</p><br/>
            <h2 id="servizi">Servizi</h2>
            <p>Ogni utente del nostro sito avrà la possibilità di registrare un
            suo proprio account che potrà utilizzare per muoversi tra le varie
            sezioni del sito, quella per i clienti e quella per i venditori.</p><br/>
            <h3 id="clienti">Servizi ai Clienti</h3>
            <p>Coloro che utilizzano il pannello dei Clienti potranno visualizzare
            la lista degli oggetti in vendita, il numero delle copie, il loro prezzo
            e una foto descrittiva, per poi comprarlo attraverso un link apposito.</p><br/>
            <h3 id="venditori">Servizi ai Venditori</h3>
            <p>Coloro che utilizzano il pannello dei Venditori potranno inserire i
            dati dell'oggetto che vogliono vendere, una foto, il suo prezzo,
            il numero degli oggetti che si vuole vendere ed una descrizione.</p><br/>
            <h2 id="sicurezza">Sicurezza e garanzie</h2>
            <p>In questo sito la garanzia degli articoli è controllata prima dai gestori,
            che ne analizzano le condizioni e la veridicità, e successivamente in caso positivo mettono
            l'articolo disponibile alla compravendita.</p><br/><br/>
            <h3 id="faq">FaQ</h3>
            <ol>
                <li><b>Posso caricare un articolo un po' malandato?</b><br>
                No, in questo sito si possono vendere solo articoli in perfette condizioni.</li>
                <li><b>Sarebbe possibile aggiungere una modalità per fare le aste?</b><br>
                No, questo sito funziona con la compravendita immediata, senza l'utilizzo di aste.</li>
            </ol>
        </div>
           <jsp:include page="footer.jsp"/>
       </div>
        
    </body>
</html>
