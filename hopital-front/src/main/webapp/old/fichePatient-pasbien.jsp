<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="dao.*"%>
<%@ page import="model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>

<%

int id = Integer.parseInt(request.getParameter("id"));

DAOPatient daoP = new DAOPatient();

Patient p = daoP.findById(id);

out.println("<h1>Fiche du patient "+id+"</h1>	");

if(p==null)
{
	out.println("Ce patient n'existe pas !");	
}
else
{
out.println("<span>Nom : "+p.getNom()+" - Prenom : "+p.getPrenom()+"<span>");
}

%>

	



</body>
</html>