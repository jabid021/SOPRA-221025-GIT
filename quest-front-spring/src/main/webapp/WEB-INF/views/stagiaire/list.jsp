<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- ETAPE 5 : EXECUTION DE LA VIEW (AVEC LES DONNEES DU MODEL) --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
<title>Liste des stagiaires</title>
</head>
<body>
<div class="container">
		<div class="card mt-3">
			<div class="card-header bg-info text-white"><span class="h2">Liste des stagiaires</span></div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
						<th>Identifiant</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Email</th>
						<th></th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${mesStagiaires}" var="stag">
							<c:url value="/stagiaire/edit" var="editUrl">
								<c:param name="id" value="${stag.id}"/>
							</c:url>
							<c:url value="/stagiaire/delete" var="deleteUrl">
								<c:param name="id" value="${stag.id}"/>
							</c:url>
							<tr>
								<td>${stag.id}</td>
								<td>${stag.nom}</td>
								<td>${stag.prenom}</td>
								<td>${stag.email}</td>
								<td>
									<div class='btn-group btn-group-sm'>
										<a href="${editUrl}" class='btn btn-primary'>
											<i class='bi bi-pencil-square'></i>
										</a>
										<a href="${deleteUrl}" class='btn btn-danger'>
											<i class='bi bi-trash'></i>
										</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
			
				</table>
			</div>
			<div class="card-footer">
				<c:url value="/stagiaire/add" var="addUrl"/>
				<a href="${addUrl}" class="btn btn-success btn-lg">
					<i class="bi bi-plus-square"></i>
				</a>
			</div>
		</div>
	</div>


<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>