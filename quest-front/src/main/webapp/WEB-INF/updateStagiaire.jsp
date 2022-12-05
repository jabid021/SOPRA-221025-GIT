<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
    
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Modifier Stagiaire</title>
</head>
<body>




<div id="content">

  <h3>Modifier Stagiaire ${stagiaire.id}</h3>
  <form action="stagiaire" method="post">
  <input type="hidden" name="id" value="${stagiaire.id}">
  Nom :<input value="${stagiaire.nom}" name="nom" type="text" placeholder="Saisir votre nom"><br>
  Prenom :<input value="${stagiaire.prenom}" name="prenom" type="text" placeholder="Saisir votre prenm"><br>
  Email :<input value="${stagiaire.email}" name="email" type="email" placeholder="Saisir votre email"><br>
  Filiere
    <select name="filiere">
              <c:forEach items="${filieres}" var="f">
              	 <option <c:if test="${stagiaire.filiere.id==f.id}">selected</c:if> value="${f.id}" >${f.id} - ${f.libelle}</option>
              </c:forEach>
                 
              </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="stagiaire"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>