<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<title>Films</title>
		<jsp:include page="../template/header.jsp"/>
	</head>
	<body>
	<jsp:include page="../template/navbar.jsp"/>

		<div class="container my-3 py-3 z-depth-1">
			<h1>Films</h1>
			<br><br>
			<div>
				<!-- Search form -->
				<form class="d-flex input-group w-auto" method="get" action="${pageContext.servletContext.contextPath}/app/films">
					<input
							type="search"
							name="titre"
							value="${titre}"
							class="form-control"
							placeholder="Titre du film"
							aria-label="Filtrer"
					/>
					<button
							class="btn btn-outline-primary"
							type="submit"
							data-mdb-ripple-color="dark"
					>
						Filtrer
					</button>
				</form>
			</div>
			<br>
			<div class="d-flex justify-content-between">
				<div class="d-flex justify-content-start">
					<a class="btn btn-primary rounded" role="button" href="${pageContext.servletContext.contextPath}/app/films/create">Ajouter</a>
				</div>
				<div class="d-flex justify-content-end">
					<h3>${fn:length(films)}</h3>
				</div>
			</div>
			<br>
			<table class="table table-hover table-striped">
				<thead class="table-light">
					<tr>
						<th><a href="${pageContext.servletContext.contextPath}/app/films/trier?sort=titreA"><i class="fas fa-sort-up"></i></a> Titre <a
								href="${pageContext.servletContext.contextPath}/app/films/trier?sort=titreD"><i class="fas fa-sort-down"></i></a></th>
						<th><a href="${pageContext.servletContext.contextPath}/app/films/trier?sort=anneeA"><i class="fas fa-sort-up"></i></a> Année <a
								href="${pageContext.servletContext.contextPath}/app/films/trier?sort=anneeD"><i class="fas fa-sort-down"></i></a></th>
						<th><a href="${pageContext.servletContext.contextPath}/app/films/trier?sort=styleA"><i class="fas fa-sort-up"></i>
						</a> Style <a
								href="${pageContext.servletContext.contextPath}/app/films/trier?sort=styleD"><i class="fas fa-sort-down"></i></a></th>
						<th><a href="${pageContext.servletContext.contextPath}/app/films/trier?sort=realisateurA"><i class="fas fa-sort-up"></i>
						</a> Réalisateur <a
								href="${pageContext.servletContext.contextPath}/app/films/trier?sort=realisateurD"><i class="fas fa-sort-down"></i></a></th>
						<th><a href="${pageContext.servletContext.contextPath}/app/films/trier?sort=dureeA"><i class="fas fa-sort-up"></i>
						</a> Durée <a
								href="${pageContext.servletContext.contextPath}/app/films/trier?sort=dureeD"><i class="fas fa-sort-down"></i></a></th>
						<th><a href="${pageContext.servletContext.contextPath}/app/films/trier?sort=vuTrue"><i class="fas fa-sort-up"></i>
						</a> Vu <a
								href="${pageContext.servletContext.contextPath}/app/films/trier?sort=vuFalse"><i class="fas fa-sort-down"></i></a></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${not empty films}">
					<c:forEach items="${films}" var="f" varStatus="bStatus">
						<tr>
							<td>
								<a id="${f.id}" href="${pageContext.servletContext.contextPath}/app/films/show?id=${f.id}" data-mdb-toggle="tooltip" data-mdb-placement="bottom" title="Afficher le film">${f.titre}</a>
							</td>
							<td>${f.annee}</td>
							<td>${f.style.libelle}</td>
							<td>${f.realisateur.nom} ${f.realisateur.prenom}</td>
							<td>${f.duree}</td>
							<td>${f.vu ? "Oui" : "Non"} </td>
							<td>
								<a class="btn btn-success" role="button" id="${f.id}" href="${pageContext.servletContext.contextPath}/app/films/edit?id=${f.id}" data-mdb-toggle="tooltip" data-mdb-placement="bottom" title="Modifier le film"><i class="fas fa-pen"></i></a>
							</td>
							<td>
								<a class="btn btn-danger" role="button" id="${f.id}" href="${pageContext.servletContext.contextPath}/app/films/delete?id=${f.id}" data-mdb-toggle="tooltip" data-mdb-placement="bottom" title="Supprimer le film"><i class="fas fa-trash"></i></a>
							</td>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
			<br>
			<c:if test="${empty films}">
				<div class="text-center">
					<h1>Aucun film ! <i class="far fa-sad-tear"></i></h1>
				</div>
			</c:if>
		</div>
		<jsp:include page="../template/footer.jsp" />
	</body>
</html>