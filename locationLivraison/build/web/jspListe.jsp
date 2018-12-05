<%@page import="diversUtilitaires.Colonne"%>
<%@page import="classesMetiers.Livreur"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="java.util.Vector"%>

<!DOCTYPE html>

<%-- ------------------------------------------------------------------- --%>
<%-- Vecteurs des livreurs et des colonnes                               --%>
<%-- ------------------------------------------------------------------- --%>
<%
    Vector<Livreur> listeLivreurs =
        (Vector)session.getAttribute("listeLivreurs");
    Vector<Colonne> listeColonnes =
        (Vector)session.getAttribute("listeColonnes");
    Livreur livreur;
%>

<html>
    <head>
        <title>Liste des livreurs</title>
        <meta http-equiv="Content-Type"
              content="text/html; charset=utf-8" />
        <!--<link rel="stylesheet"type="text/css"href="loclivcss.css" />-->
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
           <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    
    <body>
    <div class="container">
  <h2>LISTE DES LIVREURS</h2>
  <p>Salariés de la société</p>            
  <table class="table">    
            <thead>
                <tr>
                    <%
                        for (int i = 0; i < listeColonnes.size(); i++)
                        {
                            if (listeColonnes.elementAt(i).getLongueur() < 16)
                            {
                    %>
                    <th class="petitTitreColonne">
                        <%
                        }
                        else
                        {
                        %>
                    <th>
                        <%
                            }
                        %>
                        <%=listeColonnes.elementAt(i).getNom()%>
                    </th>
                    <%
                        }
                    %>
                </tr>
            </thead>  
            <tbody>
                <%
                    for (int i = 0; i < listeLivreurs.size(); i++)
                    {
                        livreur = listeLivreurs.elementAt(i);
                %>
                <tr>
                    <td>
                        <%= livreur.getIdLivreur()%>
                    </td>
                    <td>
                        <% if (livreur.getNomLivreur() != null)
                      {%>
                        <%= livreur.getNomLivreur()%>
                        <% } %>
                    </td>
                    <td>
                        <% if (livreur.getPrenomLivreur() != null)
                      {%>
                        <%= livreur.getPrenomLivreur()%>
                        <% } %>
                    </td>
                    <td>
                        <% if (livreur.getNumPermisLivreur() != null)
                      {%>
                        <%= livreur.getNumPermisLivreur()%>
                        <% } %>
                    </td>
                    <td>
                        <% if (livreur.getAdresseLivreur() != null)
                      {%>
                        <%= livreur.getAdresseLivreur()%>
                        <% } %>
                    </td>
                    <td>
                        <% if (livreur.getCodePostalLivreur() != null)
                      {%>
                        <%= livreur.getCodePostalLivreur()%>
                        <% } %>
                    </td>
                    <td>
                        <% if (livreur.getVilleLivreur() != null)
                      {%>
                        <%= livreur.getVilleLivreur()%>
                        <% } %>
                    </td>
                    <td>
                        <% if (livreur.getNumeroTelephoneLivreur()!= null)
                      {%>
                        <%= livreur.getNumeroTelephoneLivreur()%>
                        <% } %>
                    </td>
                    <td>
                        <% if (livreur.getNumeroSecteur() != null)
                      {%>
                        <%= livreur.getNumeroSecteur()%>
                        <% } %>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <p id="pListe">
            <!--<a href="ServletControleur?idEcran=2">Retour au menu principal</a>-->
            <a href="ServletControleur?idEcran=3">Retour au menu principal</a>
        </p>
    </body>
</html>