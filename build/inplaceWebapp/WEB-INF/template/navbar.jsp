<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-dark info-color sticky-top my-5">
	<a href="${pageContext.servletContext.contextPath}/index.jsp" class="navbar-brand active">
		<span class="glyphicon glyphicon-film"></span>
		<span class="glyphicon glyphicon-film"></span>
	</a>
	<button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
		<span class="icon-bar"></span>
	</button>
	<div class="navbar-collapse collapse" id="navbar-main">
		<ul class="nav navbar-nav navbar-right">
			<li ><a href="${pageContext.servletContext.contextPath}/index.jsp">Accueil</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/lister">Liste des films</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/ajouter">Ajouter un film</a></li>
			<li><a href="${pageContext.servletContext.contextPath}/listerStyle">Styles</a></li>
			<li><a href="../template/geo.jsp">Qui sommes-nous</a></li>
		</ul>
	</div>
</nav>