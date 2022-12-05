<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Modifier Ordinateur</title>
</head>
<body>



<div id="content">

  <h3>Modifier Ordinateur ${ordinateur.id}</h3>
  <form action="ordinateur" method="post">
  <input type="hidden" name="id" value="${ordinateur.id}">
  Marque :<input value="${ordinateur.marque}" name="marque" type="text" placeholder="Saisir votre marque"><br>
  RAM :<input value="${ordinateur.ram}" name="ram" type="number" placeholder="Saisir votre RAM"><br>
  Stagiaire
    <select name="stagiaire">
              <c:forEach items="${stagiaires}" var="stagiaire">
              <option  <c:if test="${stagiaire.id==ordinateur.stagiaire.id}">selected</c:if>  value="${stagiaire.id}" >${stagiaire.id} - ${stagiaire.prenom} ${stagiaire.nom}</option>
              
              </c:forEach>
              </select><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="ordinateur"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>


</body>
</html>