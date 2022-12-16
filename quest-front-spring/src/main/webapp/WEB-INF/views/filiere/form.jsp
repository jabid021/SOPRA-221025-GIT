<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-icons.css"/>">
<title>Edition de la filière</title>
</head>
<body>
	<div class="container">
		<div class="card mt-3">
		
			<form action="<c:url value="/filiere/save"/>" method="post"> 
				<input type="hidden" name="version" value="${filiere.version}"/>
				<div class="card-header bg-info text-white"><h3>Edition de la filière</h3></div>
				<div class="card-body">
					<div class="form-group">
						<label for="id">Identifiant:</label> <input type="number"
							class="form-control" name="id" readonly value="${filiere.id}">
					</div>
					<div class="form-group">
						<label for="libelle">Libellé:</label> <input type="text"
							class="form-control" name="libelle" value="${filiere.libelle}">
					</div>
					<div class="form-group">
						<label for="debut">Date de début:</label> <input type="date" 
							class="form-control" name="debut" value="${filiere.debut}">
					</div>
					<div class="form-group">
						<label for="fin">Date de fin:</label> <input type="date"
							class="form-control" name="fin" value="${filiere.fin}">
					</div>
				</div>
				<div class="card-footer d-flex justify-content-end" >
					<div class="btn-group btn-group-lg ">
						<button type="submit" class="btn btn-success">
							<i class="bi bi-check-square"></i>
						</button>
						<c:url value="/filiere/cancel" var="cancelUrl"/>
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