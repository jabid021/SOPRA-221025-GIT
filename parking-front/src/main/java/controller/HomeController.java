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
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOCompte daoC = new DAOCompte();
		
		String login=request.getParameter("login");
		String password = request.getParameter("password");
		
		Compte c = daoC.seConnecter(login, password);
		
		if(c instanceof Admin) 
		{
			request.getSession().setAttribute("compte", c);
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuAdmin.jsp").forward(request, response);

		}
		else if(c instanceof Responsable) 
		{
			request.getSession().setAttribute("compte", c);
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuResponsable.jsp").forward(request, response);

		}
		else if(c instanceof Utilisateur) 
		{
			request.getSession().setAttribute("compte", c);
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuUser.jsp").forward(request, response);

		}
		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	
		
	}

}
