/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.collezionistianime;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "Login", urlPatterns = {"/Login", "/login.html"}, 
        loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    @Override 

    public void init(){

        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH
        //"//localhost:1527/ammdb" //Nel caso non funzioni
                ;
        try {
            Class.forName(JDBC_DRIVER);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObjectFactory.getInstance().setConnectionString(dbConnection);
    }
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
        
        if(session.getAttribute("venditore")!=null){
            response.sendRedirect("venditore.html");
            return;
        }
        if(session.getAttribute("cliente")!=null){
            response.sendRedirect("cliente.html");
            return;
        }
        
        if(request.getParameter("Submit")!=null){
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            ArrayList<Utente> listaUtenti = ObjectFactory.getInstance().getUserList();
           
            for(Utente u : listaUtenti){
                if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                    session.setAttribute("loggedIn", true);
                    session.setAttribute("id", u.getId());
                    if(u instanceof Venditore){
                        if(session.getAttribute("cliente")!=null){ 
                            session.setAttribute("cliente", null);
                        }
                        session.setAttribute("venditore", u);
                        response.sendRedirect("venditore.html");
                        return;
                    }
                    else if(u instanceof Cliente){
                        if(session.getAttribute("venditore")!=null){
                            session.setAttribute("venditore", null);
                        }
                        session.setAttribute("cliente", u);
                        response.sendRedirect("cliente.html");
                        return;
                    }
                }
            }
            request.setAttribute("Errore", "Dati errati");
        }
        request.getRequestDispatcher("login.jsp").forward(request, response); 
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
