/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.collezionistianime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectFactory {
    private static ObjectFactory singleton;
    String connectionString; 
    
    public static ObjectFactory getInstance() {
        if (singleton == null) {
            singleton = new ObjectFactory();
        }
        return singleton;
    }
    
    private ObjectFactory() {
    }
    
    public ArrayList<Utente> getUserList(){
        try{
            Connection conn = DriverManager.getConnection(connectionString,"Karistan","0000");
            String query = "SELECT * FROM venditore";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query);
            
            ArrayList<Utente> utenti=new ArrayList<>();
            if(set.next()){
                Venditore utente = new Venditore();
                utente.setId(set.getInt("id"));
                utente.setNome(set.getString("nomevenditore"));
                utente.setCognome(set.getString("cognomevenditore"));
                utente.setUsername(set.getString("nickvenditore"));
                utente.setPassword(set.getString("passvenditore"));
                utente.setConto(set.
                        getInt("contovenditore"));
                utenti.add(utente);
            }
            stmt.close();
            conn.close();
            conn = DriverManager.getConnection(connectionString,"Karistan","0000");
            query = "SELECT * FROM cliente";
            stmt = conn.createStatement();
            set = stmt.executeQuery(query);
            if(set.next()){
                Cliente utente = new Cliente();
                utente.setId(set.getInt("id"));
                utente.setNome(set.getString("nomecliente"));
                utente.setCognome(set.getString("cognomecliente"));
                utente.setUsername(set.getString("nickcliente"));
                utente.setPassword(set.getString("passcliente"));
                utente.setConto(set.
                        getInt("contocliente"));
                utenti.add(utente);
            }
            stmt.close();
            conn.close();
            return utenti;
        }
        catch(SQLException e){
        }
        return null;
    }
    
    public ArrayList<Oggetto> getOggettiList(){
        try{
            Connection conn = DriverManager.getConnection(connectionString,"Karistan","0000");
            String query = "SELECT * FROM oggetto";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query);
            
            ArrayList<Oggetto> oggetti=new ArrayList<>();
            while(set.next()){
                Oggetto oggetto = new Oggetto();
                oggetto.setId(set.getInt("id"));
                oggetto.setNome(set.getString("nomeoggetto"));
                oggetto.setImmagine(set.getString("immagine"));
                oggetto.setDescrizione(set.getString("descrizione"));
                oggetto.setPezzi(set.getInt("pezzi"));
                oggetto.setPrezzo(set.getInt("prezzo"));
                oggetto.setVenditore(set.
                        getInt("venditore"));
                oggetti.add(oggetto);
            }
            stmt.close();
            conn.close();
            return oggetti;
        }
        catch(SQLException e){
        }
        return null;
    }
    
    public Oggetto getOggetto(int id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Karistan", "0000");
            String query = "SELECT * FROM oggetto WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                Oggetto oggetto = new Oggetto();
                oggetto.setId(res.getInt("id"));
                oggetto.setNome(res.getString("nomeoggetto"));
                oggetto.setImmagine(res.getString("immagine"));
                oggetto.setDescrizione(res.getString("descrizione"));
                oggetto.setPezzi(res.getInt("pezzi"));
                oggetto.setPrezzo(res.getInt("prezzo"));
                oggetto.setVenditore(res.getInt("venditore"));
                stmt.close();
                conn.close();
                return oggetto;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
        }
        return null;
    }
    
    public Utente getUtente(String username, String password){
        try{
            Connection conn = DriverManager.getConnection(connectionString,"Karistan","0000");
            String query = "SELECT * FROM venditore WHERE "
                    + "password = ? AND username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, password);
            stmt.setString(2, username);
            ResultSet set = stmt.executeQuery();
            
            if(set.next()){
                Venditore venditore = new Venditore();
                venditore.setId(set.getInt("id"));
                venditore.setNome(set.getString("nomevenditore"));
                venditore.setCognome(set.getString("cognomevenditore"));
                venditore.setUsername(set.getString("nickvenditore"));
                venditore.setPassword(set.getString("passvenditore"));
                venditore.setConto(set.getInt("contovenditore"));
                stmt.close();
                conn.close();
                return venditore;
            }
            query = "SELECT * FROM cliente WHERE "
                    + "password = ? AND username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, password);
            stmt.setString(2, username);
            set = stmt.executeQuery();
            
            if(set.next()){
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNome(set.getString("nomecliente"));
                cliente.setCognome(set.getString("cognomecliente"));
                cliente.setUsername(set.getString("nickcliente"));
                cliente.setPassword(set.getString("passcliente"));
                cliente.setConto(set.getInt("contocliente"));
                stmt.close();
                conn.close();
                return cliente;
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
        }
        return null;
    }
    
    public Utente getVenditore(int id){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Karistan", "0000");
            String query = "SELECT * FROM venditore WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                Venditore current = new Venditore();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nomevenditore"));
                current.setCognome(res.getString("cognomevenditore"));
                current.setUsername(res.getString("nickvenditore"));
                current.setPassword(res.getString("passvenditore"));
                current.setConto(res.getInt("contovenditore"));
                
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
        }
        return null;
    }
    
    public ArrayList<Oggetto> getOggetti(int idVenditore){
        ArrayList<Oggetto> lista = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Karistan", "0000");
            String query = "SELECT * FROM oggetto WHERE venditore = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, idVenditore);
            
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                Oggetto current = new Oggetto();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nomeoggetto"));
                current.setDescrizione(res.getString("descrizione"));
                current.setImmagine(res.getString("immagine"));
                current.setPezzi(res.getInt("pezzi"));
                current.setPrezzo(res.getInt("prezzo"));
                current.setVenditore(idVenditore);
                lista.add(current);
            }
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
        }
        return lista;
    }
    
    public Oggetto getOggetto(String nome){
        Oggetto oggetto = new Oggetto();
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Karistan", "0000");
            String query = "SELECT * FROM oggetto WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nome);
            ResultSet res = stmt.executeQuery();
            
            if(res.next()){
                oggetto.setId(res.getInt("id"));
                oggetto.setNome(res.getString("nome"));
                oggetto.setDescrizione(res.getString("descrizione"));
                oggetto.setImmagine(res.getString("immagine"));
                oggetto.setPezzi(res.getInt("pezzi"));
                oggetto.setPrezzo(res.getInt("prezzo"));
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
        }
        return oggetto;
    }
    
    public ArrayList<Oggetto> getOggettoByName(String text){
        ArrayList trovati = new ArrayList();
        try{
            Connection conn = DriverManager.getConnection(connectionString,"Karistan","0000");
            String query = "SELECT * FROM oggetto WHERE UPPER(nomeoggetto) LIKE UPPER(?) "
                    + "OR UPPER(descrizione) LIKE UPPER(?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,"%"+text+"%");
            stmt.setString(2,"%"+text+"%");
            ResultSet set = stmt.executeQuery();
            while(set.next()){
                Oggetto oggetto = new Oggetto();
                oggetto.setId(set.getInt("id"));
                oggetto.setNome(set.getString("nomeoggetto"));
                oggetto.setImmagine(set.getString("immagine"));
                oggetto.setDescrizione(set.getString("descrizione"));
                oggetto.setPezzi(set.getInt("pezzi"));
                oggetto.setPrezzo(set.getInt("prezzo"));
                oggetto.setVenditore(set.getInt("venditore"));
                trovati.add(oggetto);
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e){
        }
        return trovati;
    }
    
    public void Vendita(Oggetto nuovo, int idVenditore){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Karistan", "0000");
            String query = "INSERT INTO oggetto (nomeoggetto, descrizione, immagine, prezzo, pezzi, venditore)"
                    + " VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, nuovo.getNome());
            stmt.setString(2, nuovo.getDescrizione());
            stmt.setString(3, nuovo.getImmagine());
            stmt.setInt(4, nuovo.getPrezzo());
            stmt.setInt(5, nuovo.getPezzi());
            stmt.setInt(6,idVenditore);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
        }
    }
    
    public void Compera(int idOggetto,Cliente cliente){

    PreparedStatement statementCliente = null;
    PreparedStatement statementVenditore = null;
    PreparedStatement statementOggetto = null;

    String updateCliente = "UPDATE cliente SET contocliente = ? WHERE id = ?";
    String updateVenditore = "UPDATE venditore SET contovenditore = ? WHERE id = ?";
    String updateOggetto;
    Connection conn = null;
    try{
        conn = DriverManager.getConnection(connectionString, "Karistan", "0000");
        Oggetto scelto=ObjectFactory.getInstance().getOggetto(idOggetto);
        conn.setAutoCommit(false);
        if (scelto.getPezzi() > 1){
            updateOggetto = "UPDATE oggetto SET pezzi = pezzi-1 WHERE id = ?";
        }
        else{
            updateOggetto = "DELETE FROM oggetto WHERE id = ?";
        }
        statementCliente = conn.prepareStatement(updateCliente);
        statementCliente.setInt(1,cliente.getConto()-scelto.getPrezzo());
        statementCliente.setInt(2,cliente.getId());
        statementVenditore = conn.prepareStatement(updateVenditore);
        statementVenditore.setInt(1,ObjectFactory.getInstance().getVenditore(scelto.getVenditore())
                    .getConto() + scelto.getPrezzo());
        statementVenditore.setInt(2,scelto.getVenditore());
        statementOggetto = conn.prepareStatement(updateOggetto);
        statementOggetto.setInt(1, idOggetto);
        
        statementCliente.executeUpdate();
        statementVenditore.executeUpdate();
        statementOggetto.executeUpdate();
        conn.commit();
        cliente.varConto(-scelto.getPrezzo());
    }
    catch (Exception e){
        if (conn != null){
            try{
                conn.rollback();
            }
            catch (SQLException ex){
                Logger.getLogger(ObjectFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    if (statementVenditore != null){
        try{
            statementVenditore.close();
        }
        catch (SQLException ex){
        }
    }
    if (statementOggetto != null){
        try{
            statementOggetto.close();
        }
        catch (SQLException ex) {
        }
    }

    if (conn!=null){
        try{
            conn.setAutoCommit(true);
        }
        catch (SQLException ex) {
        }
    }
}
    
    public void Modifica(Oggetto modificato){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Karistan", "0000");
            String query = "UPDATE oggetto SET nomeoggetto = ?, descrizione = ?, immagine = ?, "
                    + "prezzo = ?, pezzi = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, modificato.getNome());
            stmt.setString(2, modificato.getDescrizione());
            stmt.setString(3, modificato.getImmagine());
            stmt.setInt(4, modificato.getPrezzo());
            stmt.setInt(5, modificato.getPezzi());
            stmt.setInt(6,modificato.getId());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
        }
    };
    
    public void Cancella(int cancellato){
        try{
            Connection conn = DriverManager.getConnection(connectionString, "Karistan", "0000");
            String query = "DELETE FROM oggetto WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, cancellato);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
        }
    };

    public void setConnectionString(String s){
	this.connectionString = s;
    }
    
    public String getConnectionString(){
	return this.connectionString;
    }
}
