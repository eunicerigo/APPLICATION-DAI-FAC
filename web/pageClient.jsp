<%-- 
    Document   : pageadmin
    Created on : 29 mars 2018, 10:13:30
    Author     : evaba
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Client</title>
    <h1>Hello</h1>
</head>
<body>
    <%
        String ida = (String) session.getAttribute("id");
       
        int id = Integer.parseInt(ida);
        
        bd unebd = new bd();
        ArrayList<Utilisateur> lstu = unebd.userConnect(id);
        for (Utilisateur u : lstu) {
            out.println("<ul><li>NOM:" + u.getNomu() + "</li>" + "<li>PRENOM: " + u.getPrenomu() + "</li>"
                    + "<li>MAIL: " + u.getMailu() + "</li>" + "<li>GENRE: " + u.getGenreu() + "</li>" + "<li>DATE NAISSANCE: " + u.getDatenaissanceu() + "</li>" + "<li>TEL: " + u.getTelu() + "</li>" + "<li>TYPE: " + u.getTypeu() + "</li></ul>");
        }

    %>

    <P> Completer votre insciption Sportive pour acceder au programmes <a href="profilSportif.jsp">  C'est ici </a></P> 
    
    <P><a href="modifProfilBase.jsp">Mofidier mon profil de Base </a></P>
    
    <P><a href=""> A AJOUTER Mofidier mon profil Sportif </a></P>
    
    <P><a href="modifiermdptoclient.jsp">Modifier mon mot de passe</a></P>
   
    <a href="logout.jsp?close=close">Deconnecter</a>


</body>
</html>
