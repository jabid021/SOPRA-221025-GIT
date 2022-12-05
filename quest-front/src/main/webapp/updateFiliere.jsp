<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">
<title>Modifer Filiere</title>
</head>
<body>



<div id="content">

  <h3>Modifier Filiere ${filiere.id}</h3>
  <form action="filiere" method="post">
  	<input type="hidden" name="mode" value="update">
  	<input type="hidden" name="id" value="${filiere.id}">
  	Libelle :<input value="${filiere.libelle}" name="libelle" type="text" placeholder="Saisir le libelle"><br>
	Debut :<input value="${filiere.debut}" name="debut" type="date"><br>
 	 Fin :<input value="${filiere.fin}" name="fin" type="date"><br>

  	<input class ="btn btn-warning" type="submit" value="Sauvegarder">
  	<a href="filiere"><input type="button" class ="btn btn-info" value="Retour"></a>

  </form>

</div>


</body>
</html>