<%-- 
    Document   : com
    Created on : 30 mars 2018, 20:21:18
    Author     : 21104333
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>mot de passe</title>
    </head>
    <body>
        <h1>Merci votre confiance!</h1>
        <%
           String mail =(String) session.getAttribute("email");
           out.print("<p>Voici votre mot de passe: "+mail+" récuperer réussie</p>");
            %>
    </body>
</html>
