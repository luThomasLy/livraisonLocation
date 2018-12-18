<%@page import="java.util.Vector"%>
<%@page import="classesMetiers.Secteur"%>
<%@page import="classesMetiers.Livreur"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>
<%@include file="jspHeader.jsp" %>

<% Livreur livreur = (Livreur) session.getAttribute("livreur");
    Vector<Secteur> vSect = (Vector<Secteur>) session.getAttribute("vSect");
    String message = (String) session.getAttribute("message");
    String valueInput;
    Integer valueInputInteger; // 2018/12/03 - en test : devrait permettre de faire passer les Integer 
    //(numPermisLivreur, codePostalLivreur, numeroTelephoneLivreur)
%>

<!--<html>
    <head>
        <title>Modification d'un livreur</title>
        <meta http-equiv="Content-Type"
              content="text/html; charset=utf-8" />
        <link rel="stylesheet" 
              type="text/css"
              href="loclivcss.css" />
    </head>
    <body>-->
<form action="ServletControleur?idEcran=2" method="post">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-8">
            <fieldset>
                <legend>
                    Modification du livreur <%= livreur.getIdLivreur()%>
                </legend>
                <form class="form-horizontal" action="/action_page.php">


                    <div class="divSaisieModif">
                        <% valueInput = "";
                            if (livreur.getNomLivreur() != null) {
                                valueInput = livreur.getNomLivreur();
                            }
                        %>
                        <label for="nomLivreur">Nom du livreur :</label>
                        <input type="text" 
                               name="nomLivreur" 
                               value="<%=valueInput%>" 
                               size="20" 
                               maxlength="20" 
                               id="nomLivreur" />
                    </div>

                    <div class="divSaisieModif">
                        <% valueInput = "";
                            if (livreur.getPrenomLivreur() != null) {
                                valueInput = livreur.getPrenomLivreur();
                            }
                        %>
                        <label for="prenomLivreur">Prenom du livreur :</label>
                        <input type="text" 
                               name="prenomLivreur" 
                               value="<%=valueInput%>" 
                               size="20" 
                               maxlength="20" 
                               id="prenomLivreur" />
                    </div>

                    <div class="divSaisieModif">
                        <%valueInputInteger = 0;
                            if (livreur.getNumPermisLivreur() != null) {
                                valueInputInteger = livreur.getNumPermisLivreur();
                            }
                        %>
                        <label for="numPermisLivreur">Numero de permis du livreur :</label>
                        <input type="text" 
                               name="numPermisLivreur" 
                               value="<%=valueInputInteger%>" 
                               size="20" 
                               maxlength="20" 
                               id="numPermisLivreur" />
                    </div>

                    <div class="divSaisieModif">
                        <% valueInput = "";
                            if (livreur.getAdresseLivreur() != null) {
                                valueInput = livreur.getAdresseLivreur();
                            }
                        %>
                        <label for="adresseLivreur">Adresse du livreur :</label>
                        <input type="text" 
                               name="adresseLivreur" 
                               value="<%=valueInput%>"
                               size="50" 
                               maxlength="50" 
                               id="adresseLivreur" />                
                    </div>

                    <div class="divSaisieModif">
                        <% valueInputInteger = 0;
                            if (livreur.getCodePostalLivreur() != null) {
                                valueInputInteger = livreur.getCodePostalLivreur();
                            }
                        %>
                        <label for="codePostalLivreur">Code Postal du livreur :</label>
                        <input type="text" 
                               name="codePostalLivreur" 
                               value="<%=valueInputInteger%>" 
                               size="5" 
                               maxlength="5" 
                               id="codePostalLivreur" />                
                    </div>

                    <div class="divSaisieModif">
                        <% valueInput = "";
                            if (livreur.getVilleLivreur() != null) {
                                valueInput = livreur.getVilleLivreur();
                            }
                        %>
                        <label for="villeLivreur">Ville du Livreur :</label>
                        <input type="text" 
                               name="villeLivreur" 
                               value="<%=valueInput%>"  
                               size="20" 
                               maxlength="20" 
                               id="villeLivreur" />                
                    </div>

                    <div class="divSaisieModif">
                        <% valueInputInteger = 0;
                            if (livreur.getNumeroTelephoneLivreur() != null) {
                                valueInputInteger = livreur.getNumeroTelephoneLivreur();
                            }
                        %>
                        <label for="numeroTelephoneLivreur">Numero de telephone du Livreur :</label>
                        <input type="text" 
                               name="numeroTelephoneLivreur" 
                               value="<%=valueInputInteger%>"  
                               size="20" 
                               maxlength="20" 
                               id="numeroTelephoneLivreur" />                
                    </div>

                    <div class="divSaisieModif">
                        <label for="numeroSecteur">Numero secteur :</label>
                        <% valueInputInteger = 0;
                            if (livreur.getNumeroSecteur() != null) {
                                valueInputInteger = livreur.getNumeroSecteur();
                            }
                        %>
                        <input type="text" 
                               name="numeroSecteur" 
                               value="<%=valueInputInteger%>"  
                               size="20" 
                               maxlength="20" 
                               id="numeroSecteur" />                
                    </div>
            </fieldset>
            <br />
            <br />
            <br />
            <div>
                <input type="submit" 
                       class="envoyer" 
                       name="choixAction" 
                       value="Enregistrer"/>
                <input type="submit" 
                       class="envoyer" 
                       name="choixAction" 
                       value="Annuler"/>
            </div>
        </div>
    </div>
</form>


<div>
    <br />
    <br />
    <br />
    <p id=message><%=message%></p>
</div>


<%@include file="jspFooter.jsp" %>