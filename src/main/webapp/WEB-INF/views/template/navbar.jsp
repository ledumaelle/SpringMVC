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
					<a class="nav-link active" aria-current="page" href="${pageContext.servletContext.contextPath}/app/">Accueil</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.servletContext.contextPath}/app/films">Films</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.servletContext.contextPath}/app/films/create">Ajouter un film</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.servletContext.contextPath}/app/styles">Styles</a>
				</li>
			</ul>
			<!-- Left links -->
		</div>
		<!-- Collapsible wrapper -->

		<!-- Icon dropdown -->
		<ul class="navbar-nav d-flex w-auto">
			<!-- Icon dropdown -->
			<li class="nav-item dropdown">
				<a
						class="nav-link dropdown-toggle"
						href="#"
						id="navbarDropdown"
						role="button"
						data-mdb-toggle="dropdown"
						aria-expanded="false"
				>
					<i class="united kingdom flag m-0"></i>
				</a>
				<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
					<li>
						<a class="dropdown-item" href="#"
						><i class="united kingdom flag"></i>English
							<i class="fa fa-check text-success ms-2"></i
							></a>
					</li>
					<li><hr class="dropdown-divider" /></li>
					<li>
						<a class="dropdown-item" href="#"><i class="france flag"></i>Français</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
	<!-- Container wrapper -->
</nav>
<!-- Navbar -->