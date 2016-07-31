/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.collezionistianime;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html","/Cliente"})
public class ServletCliente extends HttpServlet {

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
            String userPath = request.getServletPath();
            HttpSession session = request.getSession();
            
            if(session.getAttribute("cliente")==null){
                response.sendRedirect("login.jsp");
                return;
            }
            
            ArrayList<Oggetto> listaOggetti = ObjectFactory.getInstance().getOggettiList();
            Cliente cliente=(Cliente)session.getAttribute("cliente");
            request.setAttribute("oggetto", listaOggetti);
            String flag="Home";
            
            if(request.getParameter("ConfermaAcquisto")!=null){
                if(Integer.parseInt(request.getParameter("Prezzo")) > cliente.getConto())
                    request.setAttribute("Messaggio", "Non disponi di credito sufficiente.");
                else{
                    ObjectFactory.getInstance().Compera(Integer.parseInt(request.getParameter("idOggetto")), cliente);
                    listaOggetti=ObjectFactory.getInstance().getOggettiList();
                    request.setAttribute("oggetto", listaOggetti);
                    request.setAttribute("Messaggio", "Acquisto confermato, il credito verrà scalato.");
                }
            }
            else    
                if(request.getParameter("idOggetto")!=null){
                    flag="Compra";
                    request.setAttribute("OggettoScelto", ObjectFactory.getInstance().getOggetto(Integer.parseInt(request.getParameter("idOggetto"))));
                    request.setAttribute("Credito",cliente.getConto());
                }
        request.setAttribute("flag",flag);
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
