<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<style>
tr th, td {
	text-align: center;
}

body {
	background-color: #F4EFE7;
}

h2 {
	display: flex;
	justify-content: center;
	width: 100%;
	position: static;
}

.container {
	display: flex;
	flex-direction: column;
	width: 100%
}

.table {
	overflow-x: scroll;
}

footer {
	display: flex;
	flex-direction: row;
	justify-content: center;
	width: 100%; //
	background-color: #432BD4;
}
</style>

<html>
<head>
<title>Compte</title>
<meta charset="utf-8">
</head>
<div class="container">
	<body>

		<h2>Liste des Comptes</h2>
		<div class="table">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Login</th>
						<th scope="col">Password</th>
						<th scope="col">Nom</th>
						<th scope="col">Prenom</th>
						<th scope="col">Type Compte</th>
						<th scope="col">Entreprise</th>
						<th scope="col">Naissance</th>
						<th scope="col">Mail</th>
						<th scope="col">Tel</th>
						<th scope="col">Civilit�</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>JohnDOE</td>
						<td>21232f297a57a5a743894a0e4a801fc3</td>
						<td>DOE</td>
						<td>John</td>
						<td>Admin</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>JaneDOE</td>
						<td>5844a15e76563fedd11840fd6f40ea7b</td>
						<td>DOE</td>
						<td>Jane</td>
						<td>Responsable</td>
						<td>Parkme</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
						<td>-</td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>OmarLAMCHAKCHAK</td>
						<td>d4466cce49457cfea18222f5a7cd3573</td>
						<td>LAMCHAKCHAK</td>
						<td>Omar</td>
						<td>Utilisateur</td>
						<td>-</td>
						<td>1994-10-31</td>
						<td>omarlamchakchak@gmail.com</td>
						<td>0667656545</td>
						<td>Homme</td>
					</tr>
				</tbody>
			</table>
		</div>




	</body>

	<footer>

		<form action="#" method="POST">
			<input class="btn btn-success" type="submit" value="ajouter" /> <a
				href="updateX.hmtl?id=2" target="blank"><button type="button"
					class="btn btn-danger">modifier</button></a>

		</form>



	</footer>
</div>
</html>