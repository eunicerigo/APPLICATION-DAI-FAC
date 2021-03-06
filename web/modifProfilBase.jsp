<%-- 
    Document   : 
    Created on : 27 mars 2018, 13:17:03
    Author     : FLEXICSSS
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="metier.Utilisateur"%>
<%@page import="bd.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Mofification profil </title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" 
                  href="Vlava/js/rs-plugin/css/settings.css" media="screen">
            <link rel="stylesheet" type="text/css" href="Vlava/css/isotope.css" media="screen">
            <link rel="stylesheet" 
                  href="flexslider.css" type="text/css">
            <link rel="stylesheet" href="Vlava/js/jquery.fancybox.css" type="text/css" 
                  media="screen">
            <link rel="stylesheet" href="Vlava/css/bootstrap.css">
            <link rel="stylesheet" 
                  href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700">
            <link rel="stylesheet" href="Vlava/css/style.css">
            <!-- skin -->
            <link rel="stylesheet" href="Vlava/css/default.css">

            <SCRIPT language="JavaScript"  src="script.js">
            </script>
            <SCRIPT type =text/javascript src =fonction/fonctions.js></SCRIPT>
        </head>

        <body>
            
            <% System.out.println("");
        String ida = (String) session.getAttribute("id");
       
        int id = Integer.parseInt(ida);
        
        bd unebd = new bd();
        ArrayList<Utilisateur> lstu = unebd.userConnect(id);
        for (Utilisateur u : lstu) {
            out.println("<ul><li>NOM:" + u.getNomu() + "</li>" + "<li>PRENOM: " + u.getPrenomu() + "</li>"
                    + "<li>MAIL: " + u.getMailu() + "</li>" + "<li>GENRE: " + u.getGenreu() + "</li>" + "<li>DATE NAISSANCE: " + u.getDatenaissanceu() + "</li>" + "<li>TEL: " + u.getTelu() + "</li>" + "<li>TYPE: " + u.getTypeu() + "</li></ul>");
        }
        
       
    %>
            
            
        <section id="header" class="appear"></section>
        <div class="navbar navbar-fixed-top" role="navigation" 
             data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" 
             data-300="line-height:60px; height:60px; background-color:rgba(5, 42, 62, 1);">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="fa fa-bars color-white"></span>
                    </button>
                </div>

                <!-- Menu en haut -->
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                        <li><a href="accueil.jsp">Home</a></li>
                        <li><a href="accueil.jsp#testimonials">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Tête -->
        <section id="intro">
            <div class="intro-content">
                <h2>JEAN DAVID COACHING</h2>
                <h3>Modification du profil </h3>
            </div>
        </section>

        <!--formulaire inscription-->
        <section id="section-inscription" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">Modifier vos coordonnées</h2>
                            <h4>Les informations suivies d'un astérisque sont obligatoires.</h4>
                        </div>
                        
                        <div class='cform' id='contact-form'>
                        <form name='Formulaires' method='get' id ='Formulaires' action='ServletModifProfilBase'  onsubmit='return verifier()'>
                             
                             
                             
                             
                             
                        
 <% System.out.println("");
        String ido = (String) session.getAttribute("id");
       
        int jd = Integer.parseInt(ido);
        
        bd unebd2 = new bd();
        ArrayList<Utilisateur> lstu2 = unebd.userConnect(jd);
        for (Utilisateur u : lstu) {
            
        
       out.println("  "
               + ""
               + "<div name='genre'>"
               + " Genre : (*)"
               + "<select name='genre' id ='genre'class='form-control-static'>");
         
       
           if (u.getGenreu() == "H"){
                out.println("  "
               + "<option value='H' selected >Homme.</option>"
               + "<option value='F' >Femme.</option>" );   
               }else {
               out.println("  "
               + "<option value='H'  >Homme.</option>"
               + "<option value='F' selected>Femme.</option>" );
               
           }
           
    out.println("  "
               + " </select>"
               + "</div>"
               + "<div class='field your-name form-group'>"
               + " Nom : (*)"
               + "<input type='text' name='nom' id ='nom' placeholder='Nom class='cform-text 'size='40' value ="+ u.getNomu() +" required>"
               + " <div class='validation'></div>"
               + "</div>"
               + "<div class='field your-name form-group'>"
               + "Prénom!!! : (*)"
               + " <input type='text' name='prenom' value ="+ u.getPrenomu() + "  id ='prenom' placeholder='Prénom' class='cform-text' size='40' required>"
               + "<div class='validation'></div>"
               + "</div>"
               + "<div>"
               + "Date de naissance : (*)"
               + "<input type='text' name='date' value ="+ u.getDatenaissanceu() + " id ='date' placeholder='dd/mm/yyyy' class='cform-text' size='40' required>"
               + " </div>"
               + "<div>"
               + "Numéro de téléphone : (*)"
               + "     <input type='text' name='tel' id='tel' value = '"+ u.getTelu() + "' pattern='[0-9]{10}' class='cform-text' size='40' ></div> "
               + " <div class='field your-email form-grou'>"
               + "Adresse Email:"
               + "<input type='email' name='mail1' id='mail1' placeholder='Email' value ="+ u.getMailu() + " class='cform-text' size='40' data-rule='email' data-msg='aaaa' onkeyup='checkEmail()'required>(*)"
               + "</div>"
              
               + "<input type='hidden' value="+ido+" name='codeU'/>");

               }


    %>

                                <p><input type="submit"  value="Envoyer" class="btn btn-theme"/>
                                    <input type="reset" value="Effacer" class="btn btn-theme" /></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--footer-->
        <section id="footer" class="section footer">
            <div class="container">
                <div class="row animated opacity mar-bot20" data-andown="fadeIn" data-animation="animation">
                    <div class="col-sm-12 align-center">
                        <ul class="social-network social-circle">
                            <li><a href="#" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li>
                            <li><a href="#" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" class="icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#" class="icoLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="row align-center mar-bot20">
                    <ul class="footer-menu">
                        <li><a href="accueil.jsp">Home</a></li>
                        <li><a href="accueil.jsp#testimonials">Apercu</a></li>
                        <li><a href="accueil.jsp#section-contact">Contact</a></li>
                    </ul>
                </div>
                <div class="row align-center copyright">
                    <div class="col-sm-12">
                        <p>Copyright &copy; All rights reserved</p>
                    </div>
                </div>
            </div>
        </section>


        </body>
    </html>
</f:view>