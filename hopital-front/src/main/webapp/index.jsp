<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<style>

	.error{color:red;}
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Page d'accueil</h1>


	<form action="home" method=POST>

		Login <input type="text" placeholder="Saisir login" name="login"><br>
		Password <input type="password" placeholder="Saisir" name="password"><br>
	
		<input type="submit" value="Se connecter">
		
		<span class="error">${error}</span>

	</form>

</body>
</html>