<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../css/commun.css">
</head>
<body>
	<jsp:include page="./template/navbar.jsp"/>

<div class="container-fluid my-5 py-5 z-depth-1">

		<div class="jumbotron">
	 			 <h1>Bienvenue <small>dans notre application de gestion de films</small></h1>
	 			 <p>Vous allez pouvoir visualiser vos plus grands chefs-d'oeuvres, mais aussi ajouter, modifier ou supprimer.</p>
	 			 <p>Expérience enrichissante garantie.</p>
	 			 <p><a class="btn btn-primary btn-lg" role="button" href="template/geo.jsp">En savoir plus ...</a></p>
		</div>
	</div>
	
	<jsp:include page="template/footer.jsp" />

</body>
</html>