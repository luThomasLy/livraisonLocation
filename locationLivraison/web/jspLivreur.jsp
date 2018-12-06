<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>

<% String message = (String) session.getAttribute("message");
    String choixAction = (String) session.getAttribute("choixAction");
    String numeroLivreur = (String) session.getAttribute("numeroLivreur");
%>

<html> 
    <head>
        <title>Gestion des livreurs : menu</title>
        <meta http-equiv="Content-Type"
              content="text/html; charset=utf-8" />
        <!--<link rel="stylesheet"type="text/css"href="loclivcss.css" />-->
        <script src="livreur.js"type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>    
    </head>
    <body>
        <<nav class="navbar navbar-inverse">
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
        <br>
        <br>
        <br>
        <br>
        <br>
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-8">
                <form action="ServletControleur?idEcran=1" method="post">
                    <fieldset>
                        <legend>Gestion des livreurs</legend>
                        <div class="divSaisieAccueil">
                            <div class="divTexte">
                                <label for="numeroLivreur">Numéro de livreur :</label>
                                <input type="text"name="numeroLivreur"
                                       value="<%=numeroLivreur%>"size="8"
                                       maxlength="8"id="numeroLivreur" />
                                <br>
                                <br>
                            </div>
                            <div class="divRadio">
                                <%  if (choixAction.compareTo("modification") == 0) {
                                %>

                                <input type="radio" 
                                       name="choixAction" 
                                       value="modification" 
                                       id="radio1" 
                                       checked="checked" />
                                <%  } else {
                                %>
                                <input type="radio" 
                                       name="choixAction" 
                                       value="modification" 
                                       id="radio1" />
                                <%
                                    }
                                %>
                                <label for="radio1">Modification</label>

                                <%  if (choixAction.compareTo("création") == 0) {
                                %>        
                                <input type="radio" 
                                       name="choixAction" 
                                       value="création" 
                                       id="radio2" 
                                       checked="checked" />
                                <%  } else {
                                %>
                                <input type="radio" 
                                       name="choixAction" 
                                       value="création" 
                                       id="radio2" />
                                <%
                                    }
                                %>
                                <label for="radio2">Création</label>

                                <%  if (choixAction.compareTo("suppression") == 0) {
                                %>        
                                <input type="radio" 
                                       name="choixAction" 
                                       value="suppression" 
                                       id="radio3" 
                                       checked="checked" />
                                <%  } else {
                                %>
                                <input type="radio" 
                                       name="choixAction" 
                                       value="suppression" 
                                       id="radio3" />
                                <%
                                    }
                                %>
                                <label for="radio3">Suppression</label>

                                <br />
                                <br />

                                <%  if (choixAction.compareTo("liste") == 0) {
                                %>        
                                <input type="radio" 
                                       name="choixAction" 
                                       value="liste" 
                                       id="radio4" 
                                       checked="checked" />
                                <%  } else {
                                %>
                                <input type="radio" 
                                       name="choixAction" 
                                       value="liste" 
                                       id="radio4" />
                                <%
                                    }
                                %>
                                <label for="radio4">Liste des livreurs</label>
                            </div>
                        </div>
                    </fieldset>
                    <div>
                        <!--<input type="submit"
                               class="envoyer"
                               value="liste"
                               name="choixAction" href="ServletControleur?idEcran=1&choixAction=liste"/>-->
                        <br>
                        <br>
                        <input type="submit"
                               class="envoyer"
                               value="Envoyer" />
                    </div>
                </form>
            </div>
        </div> 
        <div>
            <br />
            <br />
            <br />
            <p id=message><%=message%></p>
        </div>
        <br>
    </body>
</html>