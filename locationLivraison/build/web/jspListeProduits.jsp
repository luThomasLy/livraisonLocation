<%@page import="classesMetiers.Produit"%>
<%@page import="diversUtilitaires.Colonne"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="java.util.Vector"%>

<%-- ------------------------------------------------------------------- --%>
<%-- Vecteurs des livreurs et des colonnes                               --%>
<%-- ------------------------------------------------------------------- --%>
<%
    Vector<Produit> listeProduits = (Vector) session.getAttribute("listeProduits");
    Vector<Colonne> listeColonnes = (Vector) session.getAttribute("listeColonnes");
    Produit produit;
%>

<%@include file="jspHeader.jsp" %>
<link href="locliv.css" rel="stylesheet" type="text/css"/>

<div class="container">
    <h2>LISTE DES PRODUITS</h2>
    <p>Disponibilités des produits</p>
    <div/>            
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
                for (int i = 0; i < listeProduits.size(); i++) {
                    produit = listeProduits.elementAt(i);
            %>
            <tr>
                <td>
                    <%= produit.getIdProduit()%>
                </td>
                <td>
                    <% if (produit.getReferenceProduit() != null) {%>
                    <%= produit.getReferenceProduit()%>
                    <% } %>
                </td>
                <td>
                    <% if (produit.getLibelleProduit() != null) {%>
                    <%= produit.getLibelleProduit()%>
                    <% } %>
                </td>
                <td>
                    <% if (produit.getPrixProduit() != null) {%>
                    <%= produit.getPrixProduit()%>
                    <% } %>
                </td>
                <td>
                    <% if (produit.getStockTotalProduit() != null) {%>
                    <%= produit.getStockTotalProduit()%>
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
    <br>
    <br>
    <br>

    <%@include file="jspFooter.jsp" %>
