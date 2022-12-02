package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOCompte;
import model.Admin;
import model.Compte;
import model.Responsable;
import model.Utilisateur;

@WebServlet("/home")
public class HomeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String lien = null;

		//S'il n'y a pas encore d'attribut compte dans la session du navigateur, c'est qu'on doit afficher la page d'accueil
		if(request.getSession().getAttribute("compte")==null) 
		{
			lien="index.jsp";
		}
		else 
		{
			Compte connected = (Compte) request.getSession().getAttribute("compte");
			if(connected instanceof Admin) 
			{
				lien="menuAdmin.jsp";
			}
			else if(connected instanceof Utilisateur) 
			{
				lien="menuUser.jsp";
			}
			else if(connected instanceof Responsable) 
			{
				lien="menuResponsable.jsp";
			}
		}

		//S'il y'a un parametre disconnect dans l'url, on retire l'attribut compte de la session et on retourne sur l'url /home (qui va nous afficher la page index du coup!)
		if(request.getParameter("disconnect")!=null) 
		{
			request.getSession().removeAttribute("compte");
			response.sendRedirect("home");
		}
		else {
			this.getServletContext().getRequestDispatcher("/WEB-INF/"+lien).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOCompte daoC = new DAOCompte();

		String login=request.getParameter("login");
		String password = request.getParameter("password");

		Compte c = daoC.seConnecter(login, password);
		if(c==null) 
		{
			request.setAttribute("error", "Identifiants invalides");
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		else {
			request.getSession().setAttribute("compte", c);
			response.sendRedirect("home");
		}
	}

}
