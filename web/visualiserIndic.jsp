<%-- 
    Document   : visualiserIndic
    Created on : 29 mars 2018, 17:24:32
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
        <title>Indicateur de client</title>
    </head>
    <body>
        <%
            //récupérer les info dans jsp
            String ida = (String) session.getAttribute("id");
            out.println(ida);
            int id = Integer.parseInt(ida);
            out.println(id);
            bd unebd = new bd();

            ArrayList<Utilisateur> lstu = unebd.userConnect(id);
            for (Utilisateur u : lstu) {
                out.println("<ul><li>NOM:" + u.getNomu() + "</li>" + "<li>PRENOM: " + u.getPrenomu() + "</li></ul>");
            }

        %>
        <h1>Indicateur de client</h1>
        <h2>Indicateur sur le status de client:</h2>
        <%            ArrayList<String> indic = unebd.indicClientStatu();
            out.println("Nombre des clients total:");
            out.println(indic.get(2));
        %>
        <p> </p>
        <%
            out.println("Pourcentage des clients validés:");
            out.println(indic.get(0) + "%");
        %>
        <p>  </p>
        <% out.println("Nombre des clients validés:");
            out.println(indic.get(3));
        %>


        <P>  </P>
            <%
                out.println("Pourcentage des clients en attente:");
                out.println(indic.get(1) + "%");
            %>
        <p> </p>
        <%  out.println("Nombre des clients en attente:");
            out.println(indic.get(4));
        %>
<a href="logout.jsp?close=close">Deconnecter</a>
    </body>
</html>
