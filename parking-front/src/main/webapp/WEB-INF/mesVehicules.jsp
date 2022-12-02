<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<style>
#tabPrincip {
	background-image: url("../assets/img/voiture.jpg");
	background-size: 100% 100%;
}

td {
	text-align: center;
}

#ajouter {
	margin-bottom: 2px;
}
</style>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
</head>

<body>

	<h1 align="center">Liste des vehicules</h1>
	<button id="ajouter" type="button" class="btn btn-success">Ajouter</button>

	<table id="tabPrincip" class="table" border align="center">

		<tr align="center">
			<th>ID</th>
			<th>Marque</th>
			<th>Plaque</th>
			<th>carburants</th>
			<th>Type</th>
			<th>nbPlace</th>
			<th>Decapotables</th>
			<th>Nb roues</th>
			<th>Actions</th>
		</tr>



		<c:forEach items="${vehicules}" var="v">

			<tr>
				<td>${v.id}</td>
				<td>${v.marque}</td>
				<td>${v.plaque}</td>
				<td>${v.carburants}</td>
				<td>${v.getClass().getSimpleName()}</td>
					
				<c:choose>
					<c:when test="${v.getClass().getSimpleName()=='Voiture'}">
						<td>${v.nbPlace}</td>
						<td>${v.decapotable}</td>
						<td>-</td>
					</c:when>
					<c:otherwise>
						<td>-</td>
						<td>-</td>
						<td>${v.roues}</td>
					</c:otherwise>
				</c:choose>
				<td><input type="button" value="Modifier"
					class="btn btn-warning"> <input type="button"
					value="Supprimer" class="btn btn-danger"></td>
			</tr>

		</c:forEach>

	</table>

	<!-- *********************************** -->

	<form>

		<legend> Ajout v�hicules </legend>
		<table class="table" border align="center">
			<tr>
				<td>Marque</td>
				<td><input required placeholder="Toyota"></td>
			</tr>
			<tr>
				<td>Plaque</td>
				<td><input required placeholder="CA-888-BB"
					pattern="[A-z 0-9 -{4,8}" title="4 � 8 lettre / chiffre"></td>
			</tr>

			<tr>
				<td>Carburants</td>
				<td><input type="checkbox"> essence <input
					type="checkbox"> diesel <input type="checkbox">
					electrique <input type="checkbox"> GPL</td>
			</tr>

			<tr>
				<td>Type</td>

				<td><select>
						<option selected>voiture</option>
						<option>moto</option>
				</select></td>

			</tr>

			<tr>
				<td>nbPlace</td>
				<td><input name="age" min="0" max="120"
					placeholder="Saisir age" type="number"></td>
			</tr>

			<tr>
				<td>Decapotable</td>
				<td><label for="oui">Oui</label><input id="oui" value="Oui"
					name="decapotable" type="radio"> <label for="non">Non</label><input
					value="non" name="decapotable" id="non" type="radio"></td>
			</tr>

			<tr>
				<td>Nb roues</td>
				<td><input name="nbroues" value="2" min="0" max="4"
					type="number"></td>
			</tr>

		</table>


		<input type="hidden" name="mode" value="insert">


	</form>


</body>