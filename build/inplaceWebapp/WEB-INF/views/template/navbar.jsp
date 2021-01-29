<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<!-- Container wrapper -->
	<div class="container-fluid">
		<a class="navbar-brand" href="#">
			<img
					src="${pageContext.servletContext.contextPath}/img/movie.png"
					height="30"
					alt="Icône"
					loading="lazy"
			/>
			Filmothèque
		</a>

		<!-- Toggle button -->
		<button
				class="navbar-toggler"
				type="button"
				data-mdb-toggle="collapse"
				data-mdb-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent"
				aria-expanded="false"
				aria-label="Toggle navigation"
		>
			<i class="fas fa-bars"></i>
		</button>

		<!-- Collapsible wrapper -->
		<div class="collapse navbar-collapse " id="navbarSupportedContent">
			<!-- Left links -->
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/app/"><spring:message code="accueil"/></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.servletContext.contextPath}/app/films"><spring:message code="films"/></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.servletContext.contextPath}/app/films/create"><spring:message code="ajouterUnFilm"/></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.servletContext.contextPath}/app/styles"><spring:message code="styles"/></a>
				</li>
				<li class="nav-item dropdown">
					<a
							class="nav-link dropdown-toggle"
							href="#"
							id="navbarDropdown"
							role="button"
							data-mdb-toggle="dropdown"
							aria-expanded="false"
					>
						<i class="france flag m-0"></i>
					</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li>
							<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/app/?lg=fr">
								<i class="france flag"></i>Français
								${mav == "fr"}<i class="fa fa-check text-success ms-2"></i>
							</a>
						</li>
						<li><hr class="dropdown-divider" /></li>
						<li>
							<a class="dropdown-item" href="${pageContext.servletContext.contextPath}/app/?lg=en"><i class="united kingdom flag"></i>Anglais</a>
						</li>
					</ul>
				</li>
			</ul>
			<!-- Left links -->
		</div>
		<!-- Collapsible wrapper -->
	</div>
	<!-- Container wrapper -->
</nav>
<!-- Navbar -->