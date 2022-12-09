package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import dao.DAOOrdinateur;
import dao.DAOStagiaire;
import dao.IDAOOrdinateur;
import dao.IDAOStagiaire;
import model.Ordinateur;
import model.Stagiaire;

@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDAOOrdinateur daoO = Singleton.getInstance().getDaoOrdinateur();
		IDAOStagiaire daoS = Singleton.getInstance().getDaoStagiaire();
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
			else {
				int id = Integer.parseInt(request.getParameter("id"));
				Ordinateur o = daoO.findById(id);
				daoO.delete(o);
				response.sendRedirect("ordinateur");
			}
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IDAOOrdinateur daoO = Singleton.getInstance().getDaoOrdinateur();
		IDAOStagiaire daoS = Singleton.getInstance().getDaoStagiaire();
		
		if(request.getParameter("id")==null) 
		{
			String marque = request.getParameter("marque");
			int ram = Integer.parseInt(request.getParameter("ram"));
			int idStagiaire= Integer.parseInt(request.getParameter("stagiaire"));
			Stagiaire s = daoS.findById(idStagiaire);
			
			Ordinateur o = new Ordinateur(marque, ram,s);
			daoO.save(o);
			response.sendRedirect("ordinateur");
		}
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int version = Integer.parseInt(request.getParameter("version"));
			String marque = request.getParameter("marque");
			int ram = Integer.parseInt(request.getParameter("ram"));
			int idStagiaire= Integer.parseInt(request.getParameter("stagiaire"));
			Stagiaire s = daoS.findById(idStagiaire);
			
			Ordinateur o = new Ordinateur(id,marque, ram,s);
			o.setVersion(version);
			daoO.save(o);
			response.sendRedirect("ordinateur");
		}
	}


}
