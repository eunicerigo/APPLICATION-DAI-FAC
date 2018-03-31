/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bd.bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eunicerigo
 */
public class ServletModifProfilBase extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            RequestDispatcher rd = null;
            
            SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");

            String genre = request.getParameter("genre");
           //out.println(genre);
            
            String nom = request.getParameter("nom");
            //out.println(nom);
            
            String prenom = request.getParameter("prenom");
           // out.println(prenom);

            int codeU = Integer.parseInt(request.getParameter("codeU"));
           //out.println(codeU);

            String datenaissance = request.getParameter("date");
            //out.println(datenaissance);
            
            
            String tel = request.getParameter("tel");
          // out.println(tel);
            
            
            String mail1 = request.getParameter("mail1");
           // out.println(mail1);

            bd newbd = new bd();
            
            int i = 0; 
           // int i = unebd.modifUtilisateur(15, "F", "Viola" , "prenom", "09-09-2001", "9999999999", "caca@gmail.com");
           i =  newbd.modifUtilisateur(codeU, genre, nom, prenom, datenaissance, tel, mail1);
           


            if (i != 0 ){
                
               // out.println("innnnnnnnnnn");
                
                out.println("<script LANGUAGE='JavaScript'>");
                out.println("alert('vos informations n'ont pas été prisent en compte);window.location='pageClient.jsp'");
                out.println("</script>");
                
                
                
                rd = request.getRequestDispatcher("pageClient.jsp");
                rd.forward(request, response);
            }else {
                
               
                 out.println("<script LANGUAGE='JavaScript'>");
                out.println("alert('modification bien prise en compte);");
                out.println("</script>");
                 out.println("outttttt");
                
                 
            }
            
            
            
        }
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
