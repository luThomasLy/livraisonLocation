<!DOCTYPE html>
<html lang="fr">
    <!--Le header est mis dans une jsp afin de faciliter les modifications et les copié/collé
    dans les autres jsp-->
    <head>
        <title>Location et Livraison</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--Le lien et les scripts nécessaires pour utiliser bootstrap 3-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <!--Le début du html et body de la jsp-->
    <body>
        <!--La nav bar qui sera mise dans chaque jsp ou page nécessaire-->
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

                        <li><a href="jspProduit.jsp">Produits</a></li>
                        <li><a href="jspCommande.jsp">Commandes</a></li>
                        <li><a href="jspLivreur.jsp">Livreurs</a></li>

                        <li><a href="#">A propos</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="jspContact.jsp">Contact</a></li>
                        <li><a href="jspLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>