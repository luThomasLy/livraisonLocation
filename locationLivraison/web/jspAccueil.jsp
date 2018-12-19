<!--la jspHeader minimisé-->
<%@include file="jspHeader.jsp" %>

<!--lien css-->
<link href="locliv.css" rel="stylesheet" type="text/css"/>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->

    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <!--l'image qui défile-->
            <img src="img/locliv-img3.jpeg" alt=""/>
            <div class="carousel-caption">
                <!--le texte avec l'image-->
                <h3>De la belle vaisselle pour tous vos évènements</h3>
                <p>"Pour que ce moment reste unique"</p>
            </div>      
        </div>

        <div class="item">
            <img src="img/locliv-img4.jpg" alt=""/>
            <div class="carousel-caption">
                <h3>Vous ne bougez pas, on livre</h3>
                <p>"Restez tranquille"</p>
            </div>      
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="container text-center">    
    <h3>On vous retire un poids, dans votre organisation</h3><br>
    <div class="row">
        <div class="col-sm-4">
            <img src="img/locliv-img5.jpg" alt=""/>
            <p></p>
        </div>
        <div class="col-sm-4"> 
            <img src="img/locliv-img6.jpg" alt=""/>
            <p></p>    
        </div>
        <div class="col-sm-4">
            <div class="well">
                <p>"Un service de table impeccable pour notre mariage" Mélanie & Eric</p>
            </div>
            <div class="well">
                <p>"Idéal pour l'évènement et qu'importe lequel. Je recommande" Pascal</p>
            </div>
        </div>
    </div>
</div><br>
<!--la jspFooter minimisé-->
<%@include file="jspFooter.jsp" %>

