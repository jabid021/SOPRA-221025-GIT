<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<link rel="stylesheet" href="style.css">

<style>
#tabPrincip {
	background-image: url("assets/img/voiture.jpg");
	background-size: 100% 100%;
}

td {
	text-align: center;
}
</style>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
</head>

<body>

	<h1 align="center">Modifier votre Vehicule</h1>

	<div id="formUpdate">
		<form action="vehicule" method="POST">

			<legend> Update véhicules </legend>

			<input type="hidden" name="mode" value="update"> <input
				type="hidden" name="id" value="${vehicule.id}">
				<input type="hidden" name="type_vehicule" value="${vehicule.getClass().getSimpleName()}"> 
			<table class="table" border align="center">
				<tr>
					<td>Marque</td>
					<td><input name="marque" required placeholder="Toyota"
						value="${vehicule.marque}"></td>
				</tr>
				<tr>
					<td>Plaque</td>
					<td><input name="plaque" value="${vehicule.plaque}" required
						placeholder="CA-888-BB" pattern="[A-z 0-9 -{4,8}"
						title="4 à 8 lettre / chiffre"></td>
				</tr>

				<tr>
					<td>Carburantss</td>
					<td>
					<c:forEach items="${carburants}" var="carburant">
						<c:choose>
						<c:when test="${vehicule.carburants.contains(carburant)}"><input name="${carburant}" checked type="checkbox"> ${carburant}</c:when>
						<c:otherwise><input name="${carburant}" type="checkbox"> ${carburant}</c:otherwise>
						</c:choose>
						
			
					
					</c:forEach>
					</td>
				</tr>

				<c:choose>

					<c:when test="${vehicule.getClass().getSimpleName()=='Voiture'}">



						<tr id="formTaille">
							<td>Taille</td>
							<td><label for="petit">Petit</label><input
								<c:if test="${vehicule.taille=='Petit'}">checked</c:if>
								id="petit" value="Petit" name="taille" type="radio"> <label
								for="petit">Moyen</label><input
								<c:if test="${vehicule.taille=='Moyen'}">checked</c:if>
								id="moyen" value="Moyen" name="taille" type="radio"> <label
								for="petit">Grand</label><input
								<c:if test="${vehicule.taille=='Grand'}">checked</c:if>
								id="grand" value="Grand" name="taille" type="radio"></td>
						</tr>

						<tr id="formNbPlace">
							<td>nbPlace</td>
							<td><input name="nbPlace" min="0" max="120"
								value="${vehicule.nbPlace}" placeholder="Saisir nb place" type="number"></td>
						</tr>

						<tr id="formDecapotable">
							<td>Decapotable</td>
							<td><label for="oui">Oui</label><input  <c:if test="${vehicule.decapotable}">checked</c:if> id="oui" value="oui"
								name="decapotable" type="radio"> <label for="non">Non</label><input
								<c:if test="${!vehicule.decapotable}">checked</c:if> value="non" name="decapotable" id="non" type="radio"></td>
						</tr>
					</c:when>

					<c:otherwise>


						<tr id="formRoues">
							<td>Nb roues</td>
							<td><input name="roues" min="0" max="4"
								value="${vehicule.roues}" type="number"></td>
						</tr>
					</c:otherwise>


				</c:choose>



			</table>

			<input type="submit" value="Update">



		</form>
		<a href="vehicule"><input type="button" value="Cancel"></a>
	</div>

</body>