<%-- 
    Document   : adminmodifstatutclient
    Created on : 29 mars 2018, 15:01:57
    Author     : wangziqi
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
        <title>modif statut client</title>
    </head>
    <body>
        <h1>Les informations de clients</h1>
        <form name="modif" action="modifier" method="get">



            <%
                String Utimodif = request.getParameter("modifier");
                //ouvrir la session
                     session.setAttribute("Utimodifff", Utimodif);
                bd unebd = new bd();
                ArrayList<Utilisateur> lstu = unebd.userInfo(Utimodif);
                for (Utilisateur u : lstu) {
                    out.println("<P>NOM: " + u.getNomu() + "</P><P>PRENOM: " + u.getPrenomu() + "</P><P>EMAIL: " + u.getMailu() + "</P><P>GENRE: " + u.getGenreu() + "</P><P>DATE DE NAISSANCE:"
                            + new SimpleDateFormat("yyyy-mm-dd").format(u.getDatenaissanceu()) + "</P><P>TEL: "
                            + "<input type='text' name='tel' value='" + u.getTelu() + "'" + "/>" + "</P><P>");

                    out.println("STATUT: <select name='select'><option value='" + u.getStatutu() + "'" + "selected>" + u.getStatutu() + "</option>");
                    if (u.getStatutu().equals("POTENTIEL")) {
                        out.println("<option value='EN ATTENTE'>EN ATTENTE</option><option value='VALIDE'>VALIDE</option></select>");
                    } else if (u.getStatutu().equals("EN ATTENTE")) {
                        out.println("<option value='VALIDE'>VALIDE</option></select>");
                    } else {
                        out.println("</select>");
                    }
                }

            %>


            <input  type="submit" name="submit" value="modifier"/>
            
            
        </form>
            
             <a href="logout.jsp?close=close">Deconnecter</a>
    </body>
</html>
