<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
	<head>
		<title>Ajouter un film</title>
		<jsp:include page="../template/header.jsp"/>
	</head>
	<body>
	<jsp:include page="../template/navbar.jsp"/>

	<div class="container my-3 py-3 z-depth-1">
		<div class="row d-flex justify-content-center">
			<div class="col-md-6">
				<h1 class="text-center mb-4">Ajout d'un film</h1>

				<form:form action="${pageContext.servletContext.contextPath}/app/films/addFilm" method="POST" class="mt-5" modelAttribute="film">

					<div class="form-outline mb-4">
						<form:input id="titre" path="titre" cssClass="form-control"/>
						<label class="form-label" for="titre">Titre</label>
					</div>
					<form:errors path="titre" cssClass="alert-danger" element="div"/>

					<div class="row mb-4">
						<div class="col">
							<div>
								<form:label path="style.id" cssClass="col-xs-2 control-label">Style</form:label>
								<div class="col-xs-10">
									<form:select path="style.id" cssClass="form-control">
										<form:options items="${styles}" itemValue="id" itemLabel="libelle"/>
									</form:select>
									<form:errors path="style" cssClass="alert-danger"/>
								</div>
							</div>
						</div>
						<div class="col d-flex justify-content-center align-items-end">
							<div class="form-outline form-check">
								<form:checkbox id="vu" path="vu" cssClass="form-check-input me-2"/>
								<label class="form-label" for="vu">Vu</label>
								<form:errors path="vu" cssClass="invalid-feedback"/>
							</div>
						</div>
					</div>

					<div class="row mb-4">
						<div class="col">
							<div class="form-outline">
								<form:input id="duree" path="duree" cssClass="form-control"/>
								<label class="form-label" for="duree">Durée</label>
								<form:errors path="duree" cssClass="invalid-feedback"/>
							</div>
						</div>
						<div class="col">
							<div class="form-outline">
								<form:input id="annee" path="annee" cssClass="form-control"/>
								<label class="form-label" for="titre">Année</label>
								<form:errors path="annee" cssClass="invalid-feedback"/>
							</div>
						</div>
					</div>

					<h6>Réalisateur</h6>
					<div class="row mb-4">
						<div class="col">
							<div class="form-outline">
								<form:input id="realisateur_nom" path="realisateur.nom" cssClass="form-control"/>
								<label class="form-label" for="realisateur_nom">Nom</label>
								<form:errors path="realisateur.nom" cssClass="alert-danger"/>
							</div>
						</div>
						<div class="col">
							<div class="form-outline">
								<form:input id="realisateur_prenom" path="realisateur.prenom" cssClass="form-control"/>
								<label class="form-label" for="realisateur_prenom">Prénom</label>
								<form:errors path="realisateur.prenom" cssClass="alert-danger"/>
							</div>
						</div>
					</div>

					<h6>Acteurs</h6>
					<div class="row mb-4">
						<c:forEach begin="0" end="2" var="ind">
							<div class="col">
								<div class="form-outline mb-1">
									<input id="acteur[${ind}]_nom" name="acteurs[${ind}].nom" value="${film.acteurs[ind].nom}" class="form-control"/>
									<label class="form-label" for="acteur[${ind}]_nom">Nom</label>
								</div>
								<div class="form-outline">
									<input id="acteur[${ind}]_prenom" name="acteurs[${ind}].prenom" value="${film.acteurs[ind].prenom}" class="form-control"/>
									<label class="form-label" for="acteur[${ind}]_nom">Prénom</label>
								</div>
							</div>
						</c:forEach>
					</div>

					<div class="form-outline mb-4">
						<form:textarea id="synopsis" path="synopsis" cssClass="form-control" rows="4"/>
						<label class="form-label" for="synopsis">Synopsis</label>
						<form:errors path="synopsis" cssClass="alert-danger"/>
					</div>

					<!-- Submit button -->
					<button type="submit" class="btn btn-primary btn-block mb-4">Ajouter</button>
				</form:form>
			</div>
		</div>
	</div>
	<jsp:include page="../template/footer.jsp" />

	</body>
</html>