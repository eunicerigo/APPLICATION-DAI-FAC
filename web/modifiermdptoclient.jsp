<%-- 
    Document   : modifiermdptoclient
    Created on : 30 mars 2018, 15:34:49
    Author     : 21104333
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>modifiermdptoclient</title>
        
         <SCRIPT type ="text/javascript" src ="fonction/fonctions.js"></SCRIPT>
    </head>

    <body>
        <h1   id ='ou'></h1>
        <h1>Modifier mot de passe  client</h1>
        
        
        <form action="servletmdp" method="post">
              <p>Bonjour, cher client:</p>
            <p>Entrez votre ancien mot de passe:</p>
 
         <%
        String ida = (String) session.getAttribute("id");
       
        int id = Integer.parseInt(ida);
        
        bd unebd = new bd();
        ArrayList<Utilisateur> lstu = unebd.userConnect(id);
        for (Utilisateur u : lstu) {            
            String mdp = u.getMdpu();
            
 
        out.println("<p><input type='text' name='mdpancien' id='mdpancien' required onkeyup='verifMDP(" + mdp + ")'> </p>" );
        }
    %>
        
        
        <p>Entrez votre nouveau mot de passe :</p>
        <p><input type="text" name="mdpnouveau" value="" required> </p>
        <p><input type='submit' id ='bouton' value='Envoyer'/></p>
   
        <p name="eunice" id ="eunice"> </p>
        
     </form>

    </body>
</html>

