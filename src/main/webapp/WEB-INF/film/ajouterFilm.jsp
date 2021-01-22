<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter Film</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../../css/commun.css">
	
</head>
<body>
<jsp:include page="../template/navbar.jsp"/>

<div class="container my-5 py-5 z-depth-1">
	<h1 class="bleu">Ajout d'un film</h1>
	<br><br>
		<div>
	<form action="ajouter" method="POST" class="form-horizontal">
				<div class="form-group">			
					<label for="titre" class="col-xs-2 control-label">Titre :</label>
					<div class="col-xs-10">
						<input id="titre"  name="titre"  placeholder="Titre du film ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="annee" class="col-xs-2 control-label">Année :</label>
					<div class="col-xs-10">
						<input id="annee" name="annee"  placeholder="Année de sortie ..."  class="form-control" /> 
					</div>
				</div>

				<div class="form-group">			
					<label for="style" class="col-xs-2 control-label">Style :</label>
					<div class="col-xs-10">
						<select name="style" id="style" class="form-control">
							<c:forEach items="${styles}" var="s">
								<option value="${s.id}">${s.libelle}</option>
							</c:forEach>
						</select>					
					</div>
				</div>
				<div class="form-group">			
					<label for="realisateur.prenom" class="col-xs-2 control-label">Réalisateur :</label>
					<div class="col-xs-5">
						<input id="realisateur.prenom"  name="realisateur_prenom"  placeholder="Prénom ..."  class="form-control" />
					</div>
					<div class="col-xs-5">
						<input id="realisateur.nom" name="realisateur_nom"  placeholder="Nom ..."  class="form-control" />
					</div>
				</div>

				<div class="form-group">			
					<label for="duree" class="col-xs-2 control-label">Durée :</label>
					<div class="col-xs-10">
						<input id="duree" name="duree"  placeholder="Durée du film (format h:mm) ..."  class="form-control" /> 
					</div>
				</div>


				<div class="form-group">			
					<label for="vu" class="col-xs-2 control-label">Vu :</label>
					<div class="col-xs-10">
						<select id="vu"  name="vu" class="form-control">
							<option value="true">Oui</option>
							<option value="false">Non</option>
						</select>					
					</div>
				</div>

				<c:forEach begin="0" end="4" var="ind">
					<div class="form-group">			
						<label for="prenom${ind}" class="col-xs-2 control-label">Acteur ${ind + 1} :</label>
						<div class="col-xs-5">
							<input id ="prenom${ind}" name="prenom${ind}" placeholder="Prénom ..." class="form-control"/>
						</div>
						<div class="col-xs-5">
							<input name ="nom${ind}"  placeholder="Nom ..." class="form-control"/>
						</div>
					</div>
				</c:forEach>

				<div class="form-group">			
					<label for="synopsis" class="col-xs-2 control-label">Synopsis :</label>
					<div class="col-xs-10">
						<textarea name="synopsis" id="synopsis" rows="5" placeholder="Résumé et commentaires ..."  class="form-control" ></textarea> 
					</div>
				</div>

				<div class="form-group" >
					<div class="col-xs-offset-2 col-xs-10">
						<button type="submit" class="btn btn-primary">Envoyer</button>			
					</div>
				</div>	
			
	</form>
	</div>
</div>
	<jsp:include page="../template/footer.jsp" />
	
</body>
</html>