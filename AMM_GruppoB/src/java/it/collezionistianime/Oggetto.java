/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.collezionistianime;

/**
 *
 * @author User
 */
public class Oggetto {
    private String nome;
    private String immagine;
    private String descrizione;
    private int pezzi;
    private int prezzo;
    private int id;
    private int venditore;
    
    public Oggetto(){
        nome="";
        immagine="";
        descrizione="";
        pezzi=0;
        prezzo=0;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the immagine
     */
    public String getImmagine() {
        return immagine;
    }

    /**
     * @param immagine the immagine to set
     */
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the pezzi
     */
    public int getPezzi() {
        return pezzi;
    }

    /**
     * @param pezzi the pezzi to set
     */
    public void setPezzi(int pezzi) {
        this.pezzi = pezzi;
    }

    /**
     * @return the prezzo
     */
    public int getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
     /**
     * @return the id
     */
    public int getVenditore() {
        return venditore;
    }

    /**
     * @param venditore the venditore to set
     */
    public void setVenditore(int venditore) {
        this.venditore = venditore;
    }
}
