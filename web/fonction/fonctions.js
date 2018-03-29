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


