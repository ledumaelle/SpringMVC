<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des styles</title>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		<h1 class="bleu">Gestion des styles</h1>
		<br> <br>
		<table class="table table-hover table-striped">
			<tr>
				<th>id</th>
				<th>Libelle </th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${styles}" var="s" varStatus="bStatus">
				<form action="modifStyle" method="Post">
					<tr>
						<input type="hidden" name="id" value="${s.id}" />
						<td>${s.id}</td>
						<td><input type="text" name="libelle" value="${s.libelle}" /></td>
						<td class="centre">
							<button type="submit" class="glyphicon glyphicon-edit vert"></button>

						</td>
						<td class="centre">
							<a href="supprimerStyle?index=${s.id}">
								<span class="glyphicon glyphicon-remove rouge"></span>
							</a>
						</td>
					</tr>
				</form>
			</c:forEach>
		</table>

		<br><br><br>
		<h2 class="bleu">Nouveau style :</h2>
		<div>
			<form action="ajouterStyle" method="POST" class="form-horizontal" >
				<div class="form-group">
					<div class="col-xs-10">
						<input name="libelle" placeholder="Libellé du style ..."
							class="form-control"  />
					</div>
					<div class="col-xs-2">
						<button type="submit" class="btn btn-primary pull-right">Envoyer</button>			
					</div>
				</div>
				
			</form>
		</div>

	</div>
	<jsp:include page="../template/footer.jsp" />

</body>
</html>