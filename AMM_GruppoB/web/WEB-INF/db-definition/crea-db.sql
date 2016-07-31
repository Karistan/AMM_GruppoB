/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: 20-lug-2016
 */

CREATE TABLE cliente 
(
    id                          INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nickcliente                 VARCHAR(128),
    nomecliente                 VARCHAR(128),
    cognomecliente              VARCHAR(128),
    passcliente                 VARCHAR(128),
    contocliente                INTEGER
);

CREATE TABLE venditore 
(
    id                          INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nickvenditore               VARCHAR(128),
    nomevenditore               VARCHAR(128),
    cognomevenditore            VARCHAR(128),
    passvenditore               VARCHAR(128),
    contovenditore              INTEGER
);

CREATE TABLE oggetto 
(
    id                          INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nomeoggetto                 VARCHAR(128),
    immagine                    VARCHAR(128),
    descrizione                 VARCHAR(128),
    pezzi                       INTEGER,
    prezzo                      INTEGER,
    venditore                   INTEGER,
    FOREIGN KEY (venditore)  REFERENCES venditore(id)
);

INSERT INTO cliente (id, nickcliente, nomecliente, cognomecliente, passcliente, contocliente) 
VALUES (default, 'KristianPaderi', 'Kristian', 'Paderi', '0000', 5000);

INSERT INTO cliente (id, nickcliente, nomecliente, cognomecliente, passcliente, contocliente) 
VALUES (default, 'JohnSmith', 'John', 'Smith', '0000', 500000);

INSERT INTO venditore (id, nickvenditore, nomevenditore, cognomevenditore, passvenditore, contovenditore) 
VALUES (default, 'PaderiKristian', 'Paderi', 'Kristian', '0000', 5000);

INSERT INTO venditore (id, nickvenditore, nomevenditore, cognomevenditore, passvenditore, contovenditore) 
VALUES (default, 'AdolfHitler', 'Adolf', 'Hitler', '0000', 50000);

INSERT INTO oggetto (id, nomeoggetto, immagine, descrizione, pezzi, prezzo, venditore) 
VALUES (default, 'Legend of Zelda: Ocarina of Time (N64)', 'images/legendofzelda64.jpg',
'Legend of Zelda: Ocarina of Time Nintendo 64 Box', 1, 35000, 1);

INSERT INTO oggetto (id, nomeoggetto, immagine, descrizione, pezzi, prezzo, venditore)  
VALUES (default, 'Autografo Valentino Rossi', 'images/autografovalentino.png',
'Autografo autentico di Valentino Rossi', 1, 200, 1);

INSERT INTO oggetto (id, nomeoggetto, immagine, descrizione, pezzi, prezzo, venditore)  
VALUES (default, 'Bronzo Mussolini', 'images/pronzomussolini.png',
'Autentiche monete di bronzo del periodo Mussolini', 15, 500, 2);

INSERT INTO oggetto (id, nomeoggetto, immagine, descrizione, pezzi, prezzo, venditore)  
VALUES (default, 'Final Fantasy VIII Collector', 'images/finalfantasy8collector.jpg',
'Collector Edition per PSX di Final Fantasy VIII', 1, 15000, 1);