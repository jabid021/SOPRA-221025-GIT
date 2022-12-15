<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
<title>Edition du stagiaire</title>
</head>
<body>
	<div class="container">
		<div class="card mt-3">
		
			<form action="<c:url value="/stagiaire/save"/>" method="post"> 
				<input type="hidden" name="version" value="${stagiaire.version}"/>
				<div class="card-header bg-info text-white"><h3>Edition du stagiaire</h3></div>
				<div class="card-body">
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" name="id" readonly value="${stagiaire.id}">
					</div>
					<div class="form-group">
						<label for="nom">Nom:</label> <input type="text"
							class="form-control" name="nom" value="${stagiaire.nom}">
					</div>
					<div class="form-group">
						<label for="prenom">Prénom:</label> <input type="text" 
							class="form-control" name="prenom" value="${stagiaire.prenom}">
					</div>
					<div class="form-group">
						<label for="email">Email:</label> <input type="text"
							class="form-control" name="email" value="${stagiaire.email}">
					</div>
				</div>
				<div class="card-footer d-flex justify-content-end" >
					<div class="btn-group btn-group-lg ">
						<button type="submit" class="btn btn-success">
							<i class="bi bi-check-square"></i>
						</button>
						<c:url value="/stagiaire/cancel" var="cancelUrl"/>
						<a href="${cancelUrl}" class="btn btn-warning">
							<i class="bi bi-backspace"></i>
						</a>
					</div>
				</div>
			</form>
		</div>
	</div>


<script src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
</body>
</html>