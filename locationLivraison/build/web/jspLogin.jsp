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

                        <li><a href="jspProduit.jsp">Produits</a></li>
                        <li><a href="jspCommande.jsp">Commandes</a></li>
                        <li><a href="jspLivreur.jsp">Livreurs</a></li>

                        <li><a href="jspContact.jsp">Contact</a></li>
                        <li><a href="">A propos</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="jspLogin.jsp">
                                <span class="glyphicon glyphicon-log-in">

                                </span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <br>
                <br>
                <br>
                <br>
                <br>
                <h4>Merci de bien vouloir vous connecter, pour accéder à votre espace :</h4>
                <br><br>
                <!--<form action="/action_page.php"> <!--A CHANGER !!!-->
                <div class="form-group">
                    <label for="email">Email address:</label>
                    <input type="email" class="form-control" id="email">
                </div>
                <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password" class="form-control" id="pwd">
                </div>
                <div class="checkbox">
                    <label><input type="checkbox"> Remember me</label>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
                </form>   
            </div>
            <div class="col-sm-4"></div>
        </div>
    </body>
    <html/>