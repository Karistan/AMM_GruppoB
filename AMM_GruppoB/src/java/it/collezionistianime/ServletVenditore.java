/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.collezionistianime;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html","/Venditore"})
public class ServletVenditore extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String flag="Home";
        String messaggio=null;
        
        if(session.getAttribute("venditore")==null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
        Venditore venditore=(Venditore)session.getAttribute("venditore");
        
        if(request.getParameter("ConfermaVendita")!=null){
            Oggetto nuovo=new Oggetto();
            if(request.getParameter("nome").equals("")  ||
                request.getParameter("descrizione").equals("")  ||
                request.getParameter("immagine").equals("")  ||
                request.getParameter("prezzo").equals("")  ||
                request.getParameter("pezzi").equals("")) {
                messaggio="Errore, dati mancanti o errati!";
                request.setAttribute("Messaggio",messaggio);
                request.setAttribute("flag",flag);
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
                return;
            }
            nuovo.setNome(request.getParameter("nome"));
            nuovo.setDescrizione(request.getParameter("descrizione"));
            nuovo.setImmagine(request.getParameter("immagine"));
            nuovo.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
            nuovo.setPezzi(Integer.parseInt(request.getParameter("pezzi")));
            ObjectFactory.getInstance().Vendita(nuovo, venditore.getId());
        }
        if(request.getParameter("ConfermaModifica")!=null){
            Oggetto nuovo=new Oggetto();
            if(request.getParameter("nome").equals("")  ||
                request.getParameter("descrizione").equals("")  ||
                request.getParameter("immagine").equals("")  ||
                request.getParameter("prezzo").equals("")  ||
                request.getParameter("pezzi").equals("")) {
                messaggio="Errore, dati mancanti o errati!";
                request.setAttribute("Messaggio",messaggio);
                request.setAttribute("flag",flag);
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
                return;
            }
            nuovo.setId(Integer.parseInt(request.getParameter("idOggetto")));
            nuovo.setNome(request.getParameter("nome"));
            nuovo.setDescrizione(request.getParameter("descrizione"));
            nuovo.setImmagine(request.getParameter("immagine"));
            nuovo.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
            nuovo.setPezzi(Integer.parseInt(request.getParameter("pezzi")));
            ObjectFactory.getInstance().Modifica(nuovo);
        }
        if(request.getParameter("ConfermaCancella")!=null){
            ObjectFactory.getInstance().Cancella(Integer.parseInt(request.getParameter("idOggetto")));
        }
        ArrayList<Oggetto> lista=ObjectFactory.getInstance().getOggetti(venditore.getId());
        request.setAttribute("oggetto",lista);
        if(request.getParameter("Modifica")!=null){
            flag="Modifica";
            request.setAttribute("oggetto",ObjectFactory.getInstance().
                    getOggetto(Integer.parseInt(request.getParameter("idOggetto"))));
        }
        if(request.getParameter("Cancella")!=null){
            flag="Cancella";
            request.setAttribute("oggetto",ObjectFactory.getInstance().
                    getOggetto(Integer.parseInt(request.getParameter("idOggetto"))));
        }
        if(request.getParameter("Vendi")!=null){
            if(request.getParameter("nome").equals("")  ||
                request.getParameter("descrizione").equals("")  ||
                request.getParameter("immagine").equals("")  ||
                request.getParameter("prezzo").equals("")  ||
                request.getParameter("pezzi").equals("")) {
                messaggio="Errore, dati mancanti o errati!";
                request.setAttribute("flag",flag);
                request.setAttribute("Messaggio",messaggio);
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
                return;
            }
            flag="Vendi";
            request.setAttribute("nome",request.getParameter("nome"));
            request.setAttribute("descrizione",request.getParameter("descrizione"));
            request.setAttribute("immagine",request.getParameter("immagine"));
            request.setAttribute("prezzo",request.getParameter("prezzo"));
            request.setAttribute("pezzi",request.getParameter("pezzi"));
        }
        request.setAttribute("flag",flag);
        request.setAttribute("Messaggio",messaggio);
        request.getRequestDispatcher("venditore.jsp").forward(request, response);
    }    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
