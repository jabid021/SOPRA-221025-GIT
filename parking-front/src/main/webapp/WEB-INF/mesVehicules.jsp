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

#ajouter {
	margin-bottom: 2px;
}

#formRoues{display:none;}

</style>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
</head>

<body>

	<h1 align="center">Liste des vehicules</h1>
	<button id="btnAjouter" type="button" class="btn btn-success">Ajouter</button>

	<table id="tabPrincip" class="table" border align="center">

		<tr align="center">
			<th>ID</th>
			<th>Marque</th>
			<th>Plaque</th>
			<th>carburants</th>
			<th>Taille</th>
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
				<td>${v.taille}</td>
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
				<td><a href="vehicule?id=${v.id}"><input type="button" value="Modifier"
					class="btn btn-warning"></a><a href="vehicule?id=${v.id}&delete"><input type="button"
					value="Supprimer" class="btn btn-danger"></a> </td>
			</tr>

		</c:forEach>

	</table>

	<!-- *********************************** -->
 <div id="formAjout">
 	<form action="vehicule" method="POST">

		<legend> Ajout véhicules </legend>
		
		<input type="hidden" name="mode" value="insert">
		
		<table class="table" border align="center">
			<tr>
				<td>Marque</td>
				<td><input name="marque" required placeholder="Toyota"></td>
			</tr>
			<tr>
				<td>Plaque</td>
				<td><input name="plaque" required placeholder="CA-888-BB"
					pattern="[A-z 0-9 -{4,8}" title="4 à 8 lettre / chiffre"></td>
			</tr>

			<tr>
				<td>Carburants</td>
				<td><input name="Essence" type="checkbox"> Essence <input
					name="Diesel" type="checkbox"> Diesel <input name="Electrique" type="checkbox">
					Electrique <input name="GPL" type="checkbox"> GPL</td>
			</tr>

			<tr>
				<td>Type</td>

				<td><select name="type_vehicule" id="type_vehicule">
						<option selected>Voiture</option>
						<option>Moto</option>
				</select></td>

			</tr>
			
			<tr id="formTaille">
				<td>Taille</td>
				<td><label for="petit">Petit</label><input  id="petit" value="Petit"
					name="taille" type="radio" checked> 
					
					<label for="petit">Moyen</label><input  id="moyen" value="Moyen"
					name="taille" type="radio">
					
					<label for="petit">Grand</label><input  id="grand" value="Grand"
					name="taille" type="radio">
					</td>
			</tr>

			<tr id="formNbPlace">
				<td>nbPlace</td>
				<td><input name="nbPlace" min="0" max="120"
					placeholder="Saisir nb place" type="number"></td>
			</tr>

			<tr id="formDecapotable">
				<td>Decapotable</td>
				<td><label for="oui">Oui</label><input  id="oui" value="oui"
					name="decapotable" type="radio"> <label for="non">Non</label><input
					checked value="non" name="decapotable" id="non" type="radio"></td>
			</tr>

			<tr id="formRoues">
				<td>Nb roues</td>
				<td><input name="roues" value="2" min="0" max="4"
					type="number"></td>
			</tr>

		</table>
	
		<input type="submit" value="Insert">



	</form>

</div>
<a href="home"><input type="button" value="Retour"></a>
</body>

<script>

btnAjouter.onclick=function()
{
	formAjout.style.display="block";	
}

type_vehicule.onchange=function()
{
	choixVehicule=type_vehicule.value;
	if(choixVehicule=="Voiture")
	{
		formNbPlace.style.display="table-row";
		formDecapotable.style.display="table-row";
		formTaille.style.display="table-row";
		formRoues.style.display="none";
		
	}
	else
	{
		formNbPlace.style.display="none";
		formDecapotable.style.display="none";
		formTaille.style.display="none";
		formRoues.style.display="table-row";
		
	}
}

</script>