<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>

<h1>Bienvenue sur le menu Secretaire</h1>

<h2>Afficher les visites d'un patient :</h2>

	<form action="patient" method="post">

		Id du patient ? : <input type="number" name="id"  placeholder="id">
		<br>
		<input type="submit" value="Rechercher">
	</form>

</body>
</html>