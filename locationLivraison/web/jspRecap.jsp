<%@page import="classesMetiers.Livreur"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>

<% Livreur livreur = (Livreur) session.getAttribute("livreur");
%>

<html>
    <head>
        <title>Enregistrement de la modification</title>
        <meta http-equiv="Content-Type"
              content="text/html; charset=utf-8" />
        <link rel="stylesheet" 
              type="text/css"
              href="loclivcss.css" />
    </head>

    <body>
        <h2>
            Enregistrement du livreur <%= livreur.getIdLivreur()%> effectué
        </h2>

        <br />
        
        <h2>
            Récapitulatif des données entrées
        </h2>
        <p>
            <%= livreur.getNomLivreur() %>
        </p>
        <p>
            <%= livreur.getPrenomLivreur()%>
        </p>
        <p>
            <%= livreur.getNumPermisLivreur()%> 
        </p>
        <p>
            <%= livreur.getAdresseLivreur()%>
        </p>
        <p>
            <%= livreur.getCodePostalLivreur()%>
        </p>
        <p>
            <%= livreur.getVilleLivreur()%>
        </p>
        <p>
            <%= livreur.getNumeroTelephoneLivreur()%>
        </p>
        <p>
            Numero secteur : <%= livreur.getNumeroSecteur()%>
        </p>

        <p>
            <a href="ServletControleur?idEcran=4">Retour au menu principal</a>
        </p>
    </body>
</html>
