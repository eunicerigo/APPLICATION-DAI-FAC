<%-- 
    Document   : modifierenattent
    Created on : 29 mars 2018, 10:21:43
    Author     : wangziqi
--%>

<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript" src="function.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier en attent</title>
    </head>
    <body>
        <h1>Modifiez le statut </h1>
        <form name="infomodif" action="adminmodifstatutclient.jsp" method="GET">
            <table border="1">
                <tr><td>Nom </td>
                    <td>Prenom </td>
                    <td>Type </td>
                    <td>Tel </td>
                    <td>Statut</td>
                    <td>Modifié</td>
                
                </tr>
               
                <%
                    bd newbd = new bd();
                    ArrayList<Utilisateur> listeU = newbd.ConsulterUtilisateur();
                    for (Utilisateur uti : listeU) {
                        //Admin peut changer le statut que pour le client et son statut ne sont pas "VALIDE"
                       if (uti.getStatutu()!= null&&!uti.getStatutu().equals("VALIDE")&&uti.getTypeu()!=null&&uti.getTypeu().equals("CLIENT")) {
                        out.print("<tr><td>" + uti.getNomu() + "</td><td> " + uti.getPrenomu() + "</td><td> " + uti.getTypeu() + "</td><td> "
                                + uti.getTelu() + "</td><td> " + uti.getStatutu() + "</td><td> "
                                + "<input type='radio' value='" + uti.getMailu() + "' name='modifier' required='required'>" + "</td></tr>");
                       }
                       else{
                          out.print("<tr><td>" + uti.getNomu() + "</td><td> " + uti.getPrenomu() + "</td><td> " + uti.getTypeu() + "</td><td> "
                                + uti.getTelu() + "</td><td> " + uti.getStatutu() + "</td><td> "
                                 + "</td></tr>"); 
                       }
                    }
                %>
                
            </table>
      
        <p><input type="submit" value="Modifier"/></p>
      </form>
                
                 <a href="logout.jsp?close=close">Deconnecter</a>
</body>
</html>
