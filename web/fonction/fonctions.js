/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getXMLHttpRequest()
{
    var xhr = null;

    // Firefox et bien d'autres.
    if (window.XMLHttpRequest)
        xhr = new XMLHttpRequest();
    else

    // Internet Explorer.
    if (window.ActiveXObject)
    {
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    // XMLHttpRequest non supporté.
    else
    {
        alert("Votre navigateur ne supporte pas l'objet XmlHttpRequest.");
        xhr = false;
    }

    return xhr;
}




function inscrireUtilisateur(){
    var xhr = getXMLHttpRequest();
    
    var genre = "genre=" + document.getElementById("genre").value;
    var nom = "nom=" + document.getElementById("nom").value;
    var prenom = "prenom=" + document.getElementById("prenom").value;
    var date = "date=" + document.getElementById("date").value;
    var tel = "tel=" + document.getElementById("tel").value;
    var mail1 = "mail1=" + document.getElementById("mail1").value;
     var mail2 = "mail2=" + document.getElementById("mail2").value;
     var mdp = "mdp=" + document.getElementById("mdp").value;
     var obj = "obj=" + document.getElementById("obj").value;
     
   
            var elt = document.getElementById("eunice");
            elt.innerHTML = "sssssssssssssssssssss"
            
     
      requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {

            var elt = document.getElementById("eunice");
            elt.innerHTML = "sssssssssssssssssssss"        
        }
    };
     

    xhr.open("GET", "ServletInscriptionUtilisation?genre=" + genre & "?nom="+ nom & "?prenom=" + prenom  & "?datenaissance=" + date & "?tel="+tel & "?mail1=" + mail1 & "?mdp=" + mdp & "?obj=" + obj);
//    xhr.open("GET", "ServletInscriptionUtilisateur?nom=" + nom);
//    xhr.open("GET", "ServletInscriptionUtilisateur?prenom=" + prenom);
//    xhr.open("GET", "ServletInscriptionUtilisateur?datenaissance=" + datenaissance);
//    xhr.open("GET", "ServletInscriptionUtilisateur?tel=" + tel);
//    xhr.open("GET", "ServletInscriptionUtilisateur?mail1=" + mail1);
//    xhr.open("GET", "ServletInscriptionUtilisateur?mdp=" + mdp);
//    xhr.open("GET", "ServletInscriptionUtilisateur?obj=" + obj);

    requeteXML.send(null);
    
     
}


function checkEmail(Formulaires) {
    if (Formulaires.mail1.value !== theForm.mail2.value)
    {
        alert('Those emails don\'t match!');
        return false;
    } else {
        return true;
    }
}

function liste_Client_EnAttente() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listeEnAttente = chargerListeClient(requeteXML.responseXML);

            var eltEnAttente = document.getElementById("clientEnAttente");
            
            eltEnAttente.innerHTML = listeEnAttente;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListerClientStatut?statut=EN ATTENTE", true);
    requeteXML.send(null);
}

function liste_Client_Potentiel() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listePotentiel = chargerListeClient(requeteXML.responseXML);

            var eltPotentiel = document.getElementById("clientPotentiel");

            eltPotentiel.innerHTML = listePotentiel;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListerClientStatut?statut=POTENTIEL", true);
    requeteXML.send(null);
}

function liste_Client_Abonne() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listeAbonne = chargerListeAbonne(requeteXML.responseXML);

            var eltAbonne = document.getElementById("clientValider");
            eltAbonne.innerHTML = listeAbonne;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListerClientStatut?statut=VALIDE", true);
    requeteXML.send(null);
}

function chargerListeClient(listeClientXML) {
    var i, client, liste, user, utilisateur;
    
    liste = liste + "<p><form method = 'get' action = 'adminmodifstatutclient.jsp'> ";
    liste = "<table>";
    liste = liste + "<th> Nom </th>";
    liste = liste + "<th> Prénom </th>";
    liste = liste + "<th> Statut </th>";
    liste = liste + "<th> Date d'inscription </th>";
    liste = liste + "<th> Modifier </th>";
    liste = liste + "<tr>";
    
    client = listeClientXML.getElementsByTagName("utilisateur");
    for (i = 0; i < client.length; i++) {
        user = client[i].firstChild.nodeValue;
        utilisateur = user.split("|");
        liste = liste + "<td>" + utilisateur[0] + "</td>";
        liste = liste + "<td>" + utilisateur[1] + "</td>";
        liste = liste + "<td>" + utilisateur[2] + "</td>";
        liste = liste + "<td>" + utilisateur[3] + "</td>";
        liste = liste + "<td> <input type = 'radio' name ='email' value = '" + 
            utilisateur[4] + "' checked> </td>";
        liste = liste + "</tr>";
    }
    liste = liste + "</table>";
    liste = liste + "<input  type='submit' name='submit' value ='Modifier' class='btn btn-theme col-lg-3'><br><br>";
    liste = liste + "</form></p>";
    return liste;
}

function chargerListeAbonne(listeClientXML) {
    var i, client, liste, user, utilisateur;
    
    //liste = liste + "<p><form method = 'get' action = 'adminsupclient.jsp'> ";
    liste = "<table>";
    liste = liste + "<th> Nom </th>";
    liste = liste + "<th> Prénom </th>";
    liste = liste + "<th> Statut </th>";
    liste = liste + "<th> Date d'inscription </th>";
    liste = liste + "<th> Supprimer </th>";
    
    client = listeClientXML.getElementsByTagName("utilisateur");
    for (i = 0; i < client.length; i++) {
        user = client[i].firstChild.nodeValue;
        utilisateur = user.split("|");
        if(utilisateur[5].toString() === "last") {
            liste = liste + "<tr bgcolor='red'>";
        } else {
            liste = liste +"<tr>"
        }
        liste = liste + "<td>" + utilisateur[0] + "</td>";
        liste = liste + "<td>" + utilisateur[1] + "</td>";
        liste = liste + "<td>" + utilisateur[2] + "</td>";
        liste = liste + "<td>" + utilisateur[3] + "</td>";
        liste = liste + "<td> <input type = 'radio' name ='email' value = '" + 
            utilisateur[4] + "' checked> </td>";
        liste = liste + "</tr>";
    }
    liste = liste + "</table>";
    
    return liste;
}
