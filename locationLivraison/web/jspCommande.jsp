<%@page contentType="text/html" pageEncoding="utf-8"%>

<!DOCTYPE html>

<% String message = (String) session.getAttribute("message");
    String choixAction = (String) session.getAttribute("choixAction");
    String idCommande = (String) session.getAttribute("idCommande");
%>

<html> 
    <head>
        <title>Gestion des Commandes : menu</title>
        <meta http-equiv="Content-Type"
              content="text/html; charset=utf-8" />
        <link rel="stylesheet"
              type="text/css"
              href="loclivcss.css" />
        <script src="livreur.js"
                type="text/javascript">
        </script>
    </head>
    
    <body>
        <form action="ServletControleur?idEcran=5" method="post">
            <fieldset>
                <legend>Gestion des Commandes</legend>
                <div class="divSaisieAccueil">
                    <div class="divTexte">
                        <label for="idCommande">Numéro de commande :</label>
                        <input type="text" 
                               name="idCommande" 
                               value="<%=idCommande%>" 
                               size="8" 
                               maxlength="8" 
                               id="idCommande" />
                    </div>
                    <div class="divRadio">
                        <%  if (choixAction.compareTo("modification") == 0)
                            { 
                        %>        
                            <input type="radio" 
                                   name="choixAction" 
                                   value="modification" 
                                   id="radio1" 
                                   checked="checked" />
                        <%  }
                            else
                            {
                        %>
                            <input type="radio" 
                                   name="choixAction" 
                                   value="modification" 
                                   id="radio1" />
                        <%
                            }
                        %>
                        <label for="radio1">Modification</label>
                        
                        <%  if (choixAction.compareTo("création") == 0)
                            { 
                        %>        
                            <input type="radio" 
                                   name="choixAction" 
                                   value="création" 
                                   id="radio2" 
                                   checked="checked" />
                        <%  }
                            else
                            {
                        %>
                            <input type="radio" 
                                   name="choixAction" 
                                   value="création" 
                                   id="radio2" />
                        <%
                            }
                        %>
                        <label for="radio2">Création</label>
                       
                        <%  if (choixAction.compareTo("suppression") == 0)
                            { 
                        %>        
                            <input type="radio" 
                                   name="choixAction" 
                                   value="suppression" 
                                   id="radio3" 
                                   checked="checked" />
                        <%  }
                            else
                            {
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
                        <br />
                        <br />
                        
                        <%  if (choixAction.compareTo("liste") == 0)
                            { 
                        %>        
                            <input type="radio" 
                                   name="choixAction" 
                                   value="liste" 
                                   id="radio4" 
                                   checked="checked" />
                        <%  }
                            else
                            {
                        %>
                            <input type="radio" 
                                   name="choixAction" 
                                   value="liste" 
                                   id="radio4" />
                        <%
                            }
                        %>
                        <label for="radio4">Liste des commandes</label>
                    </div>
                </div>
            </fieldset>
            <div>
                <!--<input type="submit"
                       class="envoyer"
                       value="liste"
                       name="choixAction" href="ServletControleur?idEcran=1&choixAction=liste"/>-->
                <input type="submit"
                       class="envoyer"
                       value="Envoyer" />
            </div>
        </form>
        <div>
            <br />
            <br />
            <br />
            <p id=message><%=message%></p>
        </div>
    </body>
</html>