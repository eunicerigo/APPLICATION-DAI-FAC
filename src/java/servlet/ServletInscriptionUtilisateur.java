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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.ProfilSportif;
import metier.Utilisateur;

/**
 *
 * @author eunicerigo
 */
public class ServletInscriptionUtilisateur extends HttpServlet {
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
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

        String genre = request.getParameter("genre");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        Date datenaissance = null;
        try {
            datenaissance = formatDate.parse(request.getParameter("datenaissance"));
        } catch (ParseException ex) {
            Logger.getLogger(ServletInscriptionUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tel = request.getParameter("tel");
        String mail1 = request.getParameter("mail1");
        String mdp = request.getParameter("mdp");
        String obj = request.getParameter("obj");
        
        String poitrine = request.getParameter("poitrine");
        String taille = request.getParameter("taille");
        String hanche = request.getParameter("hanche");
        String cuisse = request.getParameter("cuisse");
        String bras = request.getParameter("bras");
        
        ProfilSportif ps1 = new ProfilSportif(taille,hanche,cuisse,bras,poitrine);
        
        

        Utilisateur ut1 = new Utilisateur(nom, prenom, mail1, mdp, genre, datenaissance, tel, "CLIENT", datenaissance, "Potentiel");

        bd newbd = new bd();

        newbd.inscrirebaseutilisateur(ut1);
        newbd.remplirProfilSportif();
        

    }
}
