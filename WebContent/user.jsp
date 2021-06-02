<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ajout d'un client</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
	  <div class="row">
	    <div class="col">
	    </div>
	    
	    <div class="col">
			<form method="get" action="UserServlet">
			  <div class="mb-3">
			    <label for="nom" class="form-label">Nom </label>
			    <input type="text" pattern="[a-z A-Z]{4,50}" required name="nom" class="form-control" id="nom" >
			  </div>
			  <div class="mb-3">
			    <label for="prenom" class="form-label">Prénom</label>
			    <input type="text" pattern="[a-z A-Z 0-9]{4,50}" required name="prenom" class="form-control" id="prenom">
			  </div>
			  
			  <div class="mb-3">
			    <label for="login" class="form-label">Login </label>
			    <input type="text" required name="login" class="form-control" id="login" max="50">
			  </div>
			   <div class="mb-3">
			    <label for="password" class="form-label">Mot de passe</label>
			    <input type="text" required name="password" class="form-control" id="password" max="50">
			  </div>
			  <div class="mb-3">
			  	<button type="submit" class="btn btn-primary">Ajouter</button>
			  </div>
			  
			  <!-- Afficher le message d'erreur -->
			  <% if(request.getAttribute("erreurSaveUser") != null) { %>
			  	<div class="alert alert-danger" role="alert" >
					<%=request.getAttribute("erreurSaveUser") %>
				</div>
			  <% } %>
			  			  
			</form>    
		</div>
		
	    <div class="col">	      
	    </div>
	  </div>
	</div>
</body>
</html>