package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import dao.DAOFiliere;
import dao.IDAOFiliere;
import model.Filiere;

@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IDAOFiliere daoF = Singleton.getInstance().getDaoFiliere();
		//Si on ne recoit pas d'id => findAll
		if(request.getParameter("id")==null) 
		{
			String recherche = request.getParameter("recherche");
			List<Filiere> filieres;
			if(recherche==null) {
				filieres = daoF.findAll();
			}
			else 
			{
				filieres = daoF.findAllByDateFilter(LocalDate.parse(recherche));
				request.setAttribute("filtre", "( Filtrées )");
			}
			request.setAttribute("filieres", filieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request, response);	
		}
		else 
		{
		
			//pas de param delete => findById
			if(request.getParameter("delete")==null) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Filiere f = daoF.findById(id);
				request.setAttribute("filiere", f);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateFiliere.jsp").forward(request, response);	
			}
			//param id + delete => delete
			else 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Filiere f = daoF.findById(id);
				daoF.delete(f);
				response.sendRedirect("filiere");
			}
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si pas d'id en param => insert
		
		IDAOFiliere daoF = Singleton.getInstance().getDaoFiliere();
		
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			String debut = request.getParameter("debut");
			String fin = request.getParameter("fin");
			Filiere f = new Filiere(libelle, LocalDate.parse(debut), LocalDate.parse(fin));
			
			daoF.save(f);	
			response.sendRedirect("filiere");

		}
		//update"
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			String debut = request.getParameter("debut");
			String fin = request.getParameter("fin");
			Filiere f = new Filiere(id,libelle, LocalDate.parse(debut), LocalDate.parse(fin));
		
			daoF.save(f);
			response.sendRedirect("filiere");

		}
	}

}
