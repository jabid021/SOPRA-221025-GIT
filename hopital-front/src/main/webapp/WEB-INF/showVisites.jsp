<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visites du patient</title>
</head>
<body>

	<h1>Visites du patient ${visites[0].patient}</h1>

	<h2>${visites.size()}visites</h2>


	<!--<c:if test="${visites.size()==0}">
	<div>Pas de visite pour ce patient</div>
</c:if>-->


	<c:choose>
		<c:when test="${visites.size()==0}">
			<div>Pas de visite pour ce patient</div>
		</c:when>
 
		<c:when test="${visites.size()>=10}">
			<div>Beaucoup de visites !</div>
		</c:when>

		<c:otherwise>
			<c:forEach var="v" items="${visites}">
				<div>${v.id},${v.medecin}- ${v.prix} euros - ${v.salle}</div>
			</c:forEach>
		</c:otherwise>

	</c:choose>
	


	<!--  <div> ${visites[0].id}, ${visites[0].medecin} - ${visites[0].prix} - ${visites[0].salle} </div>-->

</body>
</html>