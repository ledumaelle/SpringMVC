<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../../js/commun.js"></script>
	<link rel="stylesheet" href="../../css/commun.css">

<style type="text/css">


.centre {
	text-align: center;
}


img {
	vertical-align: bottom;
}
</style>
</head>
<body>
<jsp:include page="../template/navbar.jsp"/>

<div class="container my-5 py-5 z-depth-1">
	<h1 class="bleu">Liste des films</h1>
	<br><br>
	<table class="table table-hover table-striped">
		<tr>
			<th>Titre </th>
			<th>Année </th>
			<th>Style</th>
			<th>Réalisateur</th>
			<th>Durée </th>
			<th>Vu</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${films}" var="f" varStatus="bStatus">
			<tr>
				<td><a href="afficher?index=${f.id}">${f.titre}</a></td>
				<td>${f.annee}</td>
				<td>${f.style.libelle}</td>
				<td>${f.realisateur.prenom} ${f.realisateur.nom}</td>
				<td>${f.duree}</td>
				<td>${f.vu?"Oui":"Non"}</td>
				<td class="centre">
					<a class="modif glyphicon glyphicon-edit vert"  id="m${f.id}" href="${pageContext.servletContext.contextPath}/modifFilm?index=${f.id}"></a>
				</td>
				<td class="centre">
					<a class="glyphicon glyphicon-remove rouge supp"  id="s${f.id}" href="${pageContext.servletContext.contextPath}/supprimerFilm?index=${f.id}"></a>
				</td>
			</tr>
		</c:forEach>
	</table>


	</div>
	<jsp:include page="../template/footer.jsp" />

</body>
</html>