/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function filtra(){
    var text=document.getElementById("filter").value;
    
    $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              text: text
            },
            dataType: 'json',
            success:function(data,state){
                aggiornaLista(data);
            },
            error:function(data,state){
            }
        }
    );
    
}

var Chefai="Niente";

function aggiornaLista(lista){
    $("#tabellacompra").empty();
    if(lista.length >= 1){
        var text;

        newtr=document.createElement("tr");

        newth=document.createElement("th");
        newth.appendChild(document.createTextNode("Nome"));
        newtr.appendChild(newth);

        newth=document.createElement("th");
        newth.appendChild(document.createTextNode("Immagine"));
        newtr.appendChild(newth);

        newth=document.createElement("th");
        text=document.createTextNode("Pezzi");
        newth.appendChild(text);
        newtr.appendChild(newth);

        newth=document.createElement("th");
        newth.appendChild(document.createTextNode("Prezzo"));
        newtr.appendChild(newth);

        newth=document.createElement("th");
        newth.appendChild(document.createTextNode("Compra"));
        newtr.appendChild(newth);

        $("#tabellacompra").append(newtr);
        
        for(var oggetto in lista){
            newtr=document.createElement("tr");

            newtd=document.createElement("td");
            newtd.appendChild(document.createTextNode(lista[oggetto].nome));
            newtr.appendChild(newtd);

            newtd=document.createElement("td");
            newimg=document.createElement("img");
            newimg.src=lista[oggetto].immagine;
            newimg.height=90;
            newtd.appendChild(newimg);
            newtr.appendChild(newtd);

            newtd=document.createElement("td");
            newtd.appendChild(document.createTextNode(lista[oggetto].pezzi));
            newtr.appendChild(newtd);

            newtd=document.createElement("td");
            var prezzo=lista[oggetto].prezzo/100;
            if (prezzo%1 === 0)
                prezzo = prezzo.toFixed(1);
            newtd.appendChild(document.createTextNode(prezzo+" $"));
            newtr.appendChild(newtd);

            newtd=document.createElement("td");
            newform=document.createElement("form");
            newform.method="get";
            newform.action="Cliente";
            hiddenInput=document.createElement("input");
            hiddenInput.type="hidden";
            hiddenInput.name="idOggetto";
            hiddenInput.value = lista[oggetto].id ;
            submitInput=document.createElement("input");
            submitInput.type="submit";
            submitInput.name="Compra";
            submitInput.value="Compra";
            
            newform.appendChild(hiddenInput);
            newform.appendChild(submitInput);
            newtd.appendChild(newform);
            newtr.appendChild(newtd);
            $("#tabellacompra").append(newtr);
        }
    }
    else{
        newp=document.createElement("p");
        $(newp).text("Nessun risultato trovato");
        $("#tabellacompra").append(newp);
    }
}
