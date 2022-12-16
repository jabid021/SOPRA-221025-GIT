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
<title>Liste des filières</title>
</head>
<body>
<div class="container">
		<div class="card mt-3">
			<div class="card-header bg-info text-white"><span class="h2">Liste des filières</span></div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
						<th>Identifiant</th>
						<th>Libellé</th>
						<th>Date de début</th>
						<th>Date de fin</th>
						<th></th>
					</tr>
					</thead>
					<tbody>
						<c:forEach items="${filieres}" var="filiere">
							<c:url value="/filiere/edit" var="editUrl">
								<c:param name="id" value="${filiere.id}"/>
							</c:url>
							<c:url value="/filiere/delete" var="deleteUrl">
								<c:param name="id" value="${filiere.id}"/>
							</c:url>
							<tr>
								<td>${filiere.id}</td>
								<td>${filiere.libelle}</td>
								<td>${filiere.debut}</td>
								<td>${filiere.fin}</td>
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
				<c:url value="/filiere/add" var="addUrl"/>
				<a href="${addUrl}" class="btn btn-success btn-lg">
					<i class="bi bi-plus-square"></i>
				</a>
			</div>
		</div>
	</div>


<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>