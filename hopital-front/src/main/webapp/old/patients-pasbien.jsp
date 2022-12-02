<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="dao.*"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table>

		<tr>
			<th>ID</th>
			<th>Nom</th>
			<th>Prenom</th>
		</tr>

		<%
		DAOPatient daoP = new DAOPatient();
		List<Patient> patients = daoP.findAll();
		for (Patient p : patients) {
			out.println("<tr><td>" + p.getId() + "</td><td>" + p.getNom() + "</td><td>" + p.getPrenom() + "</td></tr>");
		}
		%>

	</table>



</body>
</html>