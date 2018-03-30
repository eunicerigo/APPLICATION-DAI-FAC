<%-- 
    Document   : TEST
    Created on : 30 mars 2018, 15:31:01
    Author     : evaba
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Modif</title>
    <H1>Vous avez réussi de modifier:</H1>
</head>
<body>
    <%
        String Utimodif = (String) session.getAttribute("mailmodif");
        String sess = (String) session.getAttribute("Utimodifff");
        String statut = (String) session.getAttribute("statut");
        String tel = (String) session.getAttribute("tel");
        bd unebd = new bd();
        ArrayList<Utilisateur> lstumodif = unebd.userInfo(Utimodif);%>

   
    <%for (Utilisateur u : lstumodif) {
            out.println("Utilisateur: " + u.getNomu() + " " + u.getPrenomu());
        }
    %>
    <p> </p>
    <%
            out.println("Statut:" + statut);%>
    <p> </p>
    <%
            out.println("Tel: " + tel);%>


            <p> </p>

    <a href="logout.jsp?close=close">Deconnecter</a>
</body>
</html>
