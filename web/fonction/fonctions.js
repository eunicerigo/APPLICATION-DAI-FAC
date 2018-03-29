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





function inscrireUtilisateur() {
    var xhr = getXMLHttpRequest();
    var civ = "civ=" + document.getElementById("civilite").value;
    var nom = "nom=" + document.getElementById("nom").value;
    var prenom = "prenom=" + document.getElementById("prenom").value;
    var date = "date=" + document.getElementById("date").value;
    var tel = "tel=" + document.getElementById("tel").value;
    var mail1 = "mail1=" + document.getElementById("mail1").value;
    var mail2 = "mail2=" + document.getElementById("mail2").value;
    var mdp = "mdp=" + document.getElementById("mdp").value;
    var obj = "obj=" + document.getElementById("obj").value;
}


