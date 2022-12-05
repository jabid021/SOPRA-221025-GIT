package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFiliere;
import dao.DAOStagiaire;
import model.Filiere;
import model.Stagiaire;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOStagiaire daoS = new DAOStagiaire();
		DAOFiliere daoF = new DAOFiliere();
		
		if(request.getParameter("id")==null) 
		{
			
			List<Stagiaire> stagiaires = daoS.findAll();
			List<Filiere> filieres = daoF.findAll();
			request.setAttribute("stagiaires", stagiaires);
			request.setAttribute("filieres", filieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/stagiaires.jsp").forward(request, response);	
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Stagiaire s = daoS.findById(id);
				List<Filiere> filieres = daoF.findAll();
				request.setAttribute("stagiaire", s);
				request.setAttribute("filieres", filieres);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateStagiaire.jsp").forward(request, response);	
			}
			else 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				daoS.delete(id);
				response.sendRedirect("stagiaire");
			}
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOStagiaire daoS = new DAOStagiaire();
		DAOFiliere daoF = new DAOFiliere();
		if(request.getParameter("id")==null) 
		{
			
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			int idFiliere =Integer.parseInt(request.getParameter("filiere"));
			
			Filiere f = daoF.findById(idFiliere);
			
			Stagiaire s = new Stagiaire(nom, prenom, email, f);
			daoS.insert(s);
			response.sendRedirect("stagiaire");
		}
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			int idFiliere =Integer.parseInt(request.getParameter("filiere"));
			
			Filiere f = daoF.findById(idFiliere);
			
			Stagiaire s = new Stagiaire(id,nom, prenom, email, f);
			daoS.update(s);
			response.sendRedirect("stagiaire");
		}
	}


}
