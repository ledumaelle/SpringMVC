<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
	<head>
		<title>Film</title>
		<jsp:include page="../template/header.jsp"/>
	</head>
	<body>
		<jsp:include page="../template/navbar.jsp"/>
		<div class="container my-3 py-3 z-depth-1">
			<div class="row d-flex justify-content-center">
				<div class="col-md-6">
					<h1 class="text-center mb-4">Film</h1>

					<form:form class="mt-5" modelAttribute="film" readonly="true">

						<div class="form-outline mb-4">
							<form:input id="titre" path="titre" cssClass="form-control" readonly="true"/>
							<label class="form-label" for="titre">Titre</label>
						</div>

						<div class="row mb-4">
							<div class="col">
								<div class="form-outline">
									<form:input id="style" path="style.libelle" cssClass="form-control" readonly="true"/>
									<label class="form-label" for="style">Style</label>
								</div>
							</div>
							<div class="col d-flex justify-content-center align-items-end">
								<div class="form-outline form-check">
									<form:checkbox id="vu" path="vu" cssClass="form-check-input me-2" readonly="true"/>
									<label class="form-label" for="vu" readonly="true">Vu</label>
								</div>
							</div>
						</div>

						<div class="row mb-4">
							<div class="col">
								<div class="form-outline">
									<form:input id="duree" path="duree" cssClass="form-control" readonly="true"/>
									<label class="form-label" for="duree">Durée</label>
								</div>
							</div>
							<div class="col">
								<div class="form-outline">
									<form:input id="annee" path="annee" cssClass="form-control" readonly="true"/>
									<label class="form-label" for="titre">Année</label>
								</div>
							</div>
						</div>

						<h6>Réalisateur</h6>
						<div class="row mb-4">
							<div class="col">
								<div class="form-outline">
									<form:input id="realisateur_nom" path="realisateur.nom" cssClass="form-control" readonly="true"/>
									<label class="form-label" for="realisateur_nom">Nom</label>
								</div>
							</div>
							<div class="col">
								<div class="form-outline">
									<form:input id="realisateur_prenom" path="realisateur.prenom" cssClass="form-control" readonly="true"/>
									<label class="form-label" for="realisateur_prenom">Prénom</label>
								</div>
							</div>
						</div>

						<h6>Acteurs</h6>
						<div class="row mb-4">
							<c:forEach begin="0" end="2" var="ind">
								<div class="col">
									<div class="form-outline mb-1">
										<input id="acteur[${ind}]_nom" name="acteurs[${ind}].nom" value="${film.acteurs[ind].nom}" class="form-control" readonly/>
										<label class="form-label" for="acteur[${ind}]_nom">Nom</label>
									</div>
									<div class="form-outline">
										<input id="acteur[${ind}]_prenom" name="acteurs[${ind}].prenom" value="${film.acteurs[ind].prenom}" class="form-control" readonly/>
										<label class="form-label" for="acteur[${ind}]_nom">Prénom</label>
									</div>
								</div>
							</c:forEach>
						</div>

						<div class="form-outline mb-4">
							<form:textarea id="synopsis" path="synopsis" cssClass="form-control" rows="4" readonly="true"/>
							<label class="form-label" for="synopsis">Synopsis</label>
						</div>

						<a class="btn btn-light" role="button" href="${pageContext.servletContext.contextPath}/app/films">Retour</a>

					</form:form>
				</div>
			</div>
		</div>
		<jsp:include page="../template/footer.jsp" />

	</body>
</html>