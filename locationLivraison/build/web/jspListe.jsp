<%@page import="diversUtilitaires.Colonne"%>
<%@page import="classesMetiers.Livreur"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="java.util.Vector"%>

<!DOCTYPE html>

<%-- ------------------------------------------------------------------- --%>
<%-- Vecteurs des livreurs et des colonnes                               --%>
<%-- ------------------------------------------------------------------- --%>
<%
    Vector<Livreur> listeLivreurs
            = (Vector) session.getAttribute("listeLivreurs");
    Vector<Colonne> listeColonnes
            = (Vector) session.getAttribute("listeColonnes");
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
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#">locationLivraison</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="jspAccueil.jsp">Accueil</a></li>

                        <li><a href="jspProduit">Produits</a></li>
                        <li><a href="jspCommande.jsp">Commandes</a></li>
                        <li><a href="jspLivreur.jsp">Livreurs</a></li>

                        <li><a href="jspContact.jsp">Contact</a></li>
                        <li><a href="#">A propos</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="jspLogin.jsp">
                                <span class="glyphicon glyphicon-log-in">

                                </span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <h2>LISTE DES LIVREURS</h2>
            <p>Salariés de la société</p>            
            <table class="table">    
                <thead>
                    <tr>
                        <%
                            for (int i = 0; i < listeColonnes.size(); i++) {
                                if (listeColonnes.elementAt(i).getLongueur() < 16) {
                        %>
                        <th class="petitTitreColonne">
                            <%
                            } else {
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
                        for (int i = 0; i < listeLivreurs.size(); i++) {
                            livreur = listeLivreurs.elementAt(i);
                    %>
                    <tr>
                        <td>
                            <%= livreur.getIdLivreur()%>
                        </td>
                        <td>
                            <% if (livreur.getNomLivreur() != null) {%>
                            <%= livreur.getNomLivreur()%>
                            <% } %>
                        </td>
                        <td>
                            <% if (livreur.getPrenomLivreur() != null) {%>
                            <%= livreur.getPrenomLivreur()%>
                            <% } %>
                        </td>
                        <td>
                            <% if (livreur.getNumPermisLivreur() != null) {%>
                            <%= livreur.getNumPermisLivreur()%>
                            <% } %>
                        </td>
                        <td>
                            <% if (livreur.getAdresseLivreur() != null) {%>
                            <%= livreur.getAdresseLivreur()%>
                            <% } %>
                        </td>
                        <td>
                            <% if (livreur.getCodePostalLivreur() != null) {%>
                            <%= livreur.getCodePostalLivreur()%>
                            <% } %>
                        </td>
                        <td>
                            <% if (livreur.getVilleLivreur() != null) {%>
                            <%= livreur.getVilleLivreur()%>
                            <% } %>
                        </td>
                        <td>
                            <% if (livreur.getNumeroTelephoneLivreur() != null) {%>
                            <%= livreur.getNumeroTelephoneLivreur()%>
                            <% } %>
                        </td>
                        <td>
                            <% if (livreur.getNumeroSecteur() != null) {%>
                            <%= livreur.getNumeroSecteur()%>
                            <% } %>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
                <br>
                <br>
                
            <p id="pListe">
                <!--<a href="ServletControleur?idEcran=2">Retour au menu principal</a>-->
                <a href="ServletControleur?idEcran=3">Retour au menu principal</a>
            </p>
                <br>
                <br>
                
            <footer class="container-fluid text-center">
                <p>Copyright Thomas LY</p>
            </footer>
    </body>
</html>