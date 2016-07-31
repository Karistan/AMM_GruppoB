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

public class Utente {
    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private Integer conto;
    
    public Utente(){
        nome="";
        cognome="";
        username="";
        password="";
        conto=0;
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
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the conto
     */
    public Integer getConto() {
        return conto;
    }

    /**
     * @param conto the conto to set
     */
    public void setConto(int conto) {
        this.conto = conto;
    }
    
    public void varConto(int cambiamento){
        this.conto+=cambiamento;
    }
}
