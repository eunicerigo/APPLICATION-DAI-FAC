/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bd.bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author evaba
 */
@WebServlet(name = "verif", urlPatterns = {"/verif"})
public class verif extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher rd = null;
            //GET Utilisateur
            String email = request.getParameter("txtemail");
            String mdp = request.getParameter("txtmdp");
            bd unebd = new bd();
            int rs = unebd.verifLogin(email, mdp);
            String ida = String.valueOf(unebd.idUser(email, mdp));
            //out.println("alert(ida);window.location='connection.html'");
            //verifier
            //COACH
            if (rs == 1) {
                // out.println("coach Login succes!!!");
                request.setAttribute("id", ida);
                rd = request.getRequestDispatcher("index.jsp");// il faut changer adresse

                rd.forward(request, response);
            } //CLIENT
            else if (rs == 2) {
                //     out.println(" client Login sucess!!!");
                request.setAttribute("id", ida);
                rd = request.getRequestDispatcher("inscription.jsp");// il faut changer adresse
                rd.forward(request, response);
            } //ADMIN
            else if (rs == 3) {
                //  out.println(" admin Login sucess!!!");
                request.setAttribute("id", ida);
                rd = request.getRequestDispatcher("/pageadmin.jsp");// il faut changer adresse
                rd.forward(request, response);
            } else //ko
            {
                out.println("<script LANGUAGE='JavaScript'>");
                out.println("alert('Adresse mail ou mot de passe pas correct!!!');window.location='connection.html'");

                out.println("</script>");

            }
          //  rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(verif.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(verif.class.getName()).log(Level.SEVERE, null, ex);
        }
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
