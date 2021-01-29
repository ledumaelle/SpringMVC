<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<title>Styles</title>
		<jsp:include page="../template/header.jsp"/>
	</head>
	<body>
	<jsp:include page="../template/navbar.jsp"/>

	<div class="container my-5 py-5 z-depth-1">
		<h1>Styles</h1>

		<br><br>
		<h3><spring:message code="style.nouveau"/></h3>
		<div>
			<form:form action="${pageContext.servletContext.contextPath}/app/styles/addStyle" method="post" class="form-horizontal" modelAttribute="style" >
				<div class="row form-group">
					<div class="col-md-10">
						<spring:message code="style.libelle.placeholder"
										var="labelPlaceholder" />
						<form:input path="libelle" placeholder="${labelPlaceholder}"
									cssClass="form-control" />
						<form:errors path="libelle" />
					</div>
					<div class="col-md-2">
						<button type="submit" class="btn btn-primary pull-right"><spring:message code="button.envoyer"/></button>
					</div>
				</div>

			</form:form>
		</div>

		<br><br>
		<table class="table table-hover table-striped">
			<tr>
				<th><spring:message code="style.libelle"/></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${styles}" var="s" varStatus="bStatus">
				<form action="editStyle" method="post">
					<tr>
						<input type="hidden" name="id" value="${s.id}" />
						<td><input type="text" name="libelle" value="${s.libelle}" /></td>
						<td>
							<button type="submit" class="btn btn-success"><i class="fas fa-pen"></i></button>
						</td>
						<td>
							<a class="btn btn-danger" role="button" id="${s.id}" href="${pageContext.servletContext.contextPath}/app/styles/delete?id=${s.id}"><i class="fas fa-trash"></i></a>
						</td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="../template/footer.jsp" />
	</body>
</html>