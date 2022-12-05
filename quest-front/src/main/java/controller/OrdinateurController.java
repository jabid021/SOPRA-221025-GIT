package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOOrdinateur;
import dao.DAOStagiaire;
import model.Ordinateur;
import model.Stagiaire;

@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOOrdinateur daoO = new DAOOrdinateur();
		DAOStagiaire daoS = new DAOStagiaire();
		if(request.getParameter("id")==null) 
		{
			
			List<Ordinateur> ordinateurs = daoO.findAll();
			List<Stagiaire> stagiaires = daoS.findAll();
			request.setAttribute("ordinateurs", ordinateurs);
			request.setAttribute("stagiaires", stagiaires);
			this.getServletContext().getRequestDispatcher("/WEB-INF/ordinateurs.jsp").forward(request, response);	
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Ordinateur o = daoO.findById(id);
				List<Stagiaire> stagiaires = daoS.findAll();
				request.setAttribute("ordinateur", o);
				request.setAttribute("stagiaires", stagiaires);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateOrdinateur.jsp").forward(request, response);	
			}
			else {}
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")==null) 
		{
			
		}
		else 
		{
			
		}
	}


}
