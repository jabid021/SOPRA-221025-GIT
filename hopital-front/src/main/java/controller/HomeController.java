package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import dao.IDAOCompte;
import model.Compte;
import model.Medecin;
import model.Secretaire;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOCompte daoC = Singleton.getInstance().getDaoCompte();
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Compte c = daoC.seConnecter(login, password);
		
		if(c instanceof Medecin) 
		{
			request.setAttribute("compte", c);
			this.getServletContext().getRequestDispatcher("/menuMedecin.jsp").forward(request, response);
		}
		else if(c instanceof Secretaire) 
		{
			this.getServletContext().getRequestDispatcher("/menuSecretaire.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
