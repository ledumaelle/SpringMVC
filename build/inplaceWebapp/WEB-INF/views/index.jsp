<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<title>Filmothèque</title>
		<jsp:include page="template/header.jsp"/>
	</head>
	<body>
		<jsp:include page="template/navbar.jsp"/>

		<div class="container">
			<div class="justify-content-center align-items-center d-flex mt-5">
				<h1><spring:message code="accueil.bienvenue"/></h1>
			</div>
			<div class="d-flex justify-content-center align-items-center mt-5 mb-5">
				<img src="${pageContext.servletContext.contextPath}/img/netflix.jpg" class="img-fluid" alt="img_accueil"/>
			</div>
		</div>
		<jsp:include page="template/footer.jsp" />
	</body>
</html>
