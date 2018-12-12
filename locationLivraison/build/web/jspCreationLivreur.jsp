<%@include file="jspHeader.jsp" %>

<div class="container">
  <h2>Formulaire de création des livreurs</h2>
  <br>
  <br>
  <br>
  <form class="form-horizontal" action="/action_page.php">
    <div class="form-group">
      <label class="control-label col-sm-2" for="nom">Nom</label>
      <div class="col-sm-6">
        <input type="nom" class="form-control" id="nom" name="nom">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="prenom">Prénom</label>
      <div class="col-sm-6">          
        <input type="prenom" class="form-control" id="prenom" name="prenom">
      </div>
    </div>
        <div class="form-group">
      <label class="control-label col-sm-2" for="numPermis">Numéro de permis</label>
      <div class="col-sm-6">          
        <input type="numPermis" class="form-control" id="numPermis" name="numPermis">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="adresse">Adresse</label>
      <div class="col-sm-6">          
        <input type="adresse" class="form-control" id="adresse" name="adresse">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="codePostal">Code postal</label>
      <div class="col-sm-6">          
        <input type="codePostal" class="form-control" id="codePostal" name="codePostal">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="ville">Ville</label>
      <div class="col-sm-6">          
        <input type="ville" class="form-control" id="ville" name="ville">
      </div>
    </div>
        <div class="form-group">
      <label class="control-label col-sm-2" for="numTel">Numéro de téléphone</label>
      <div class="col-sm-6">          
        <input type="numTel" class="form-control" id="numTel" name="numTel">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">Email</label>
      <div class="col-sm-6">          
        <input type="email" class="form-control" id="email" placeholder="XXXXXXXXXX@XXXXXXXXXX" name="email">
      </div>
    </div>
      <br>
  <br>
  <br>
    
    <div class="form-group">        
       <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>

<br>
<br>
<br>
<br>
<br>

<%@include file="jspFooter.jsp" %>