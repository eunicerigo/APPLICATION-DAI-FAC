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
        <title>Page Admin</title>
    <h1>Hello</h1>
</head>
<body>
    <%
        String ida = (String) request.getAttribute("id");
        session.setAttribute("id", ida);
        int id = Integer.parseInt(ida);

        bd unebd = new bd();
        ArrayList<Utilisateur> lstu = unebd.userConnect(id);
        for (Utilisateur u : lstu) {
            out.println("<ul><li>NOM:" + u.getNomu() + "</li>" + "<li>PRENOM: " + u.getPrenomu() + "</li>"
                    + "<li>MAIL: " + u.getMailu() + "</li>" + "<li>GENRE: " + u.getGenreu() + "</li>" + "<li>DATE NAISSANCE: " + new SimpleDateFormat("yyyy-mm-dd").format(u.getDatenaissanceu()) + "</li>" + "<li>TEL: " + u.getTelu() + "</li>" + "<li>TYPE: " + u.getTypeu() + "</li></ul>");
        }

    %>

    <P><a href="">Visualiser la liste des client</a></P> 
    <P><a href="">Visualiser les indicateurs sur client</a></P>
    </br><a href='accueil.jsp'>
               <%session.invalidate();
                %>Deconnecter</a>


</body>
</html>
