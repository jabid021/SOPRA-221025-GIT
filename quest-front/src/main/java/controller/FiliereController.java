package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFiliere;
import model.Filiere;

@WebServlet("/filiere")
public class FiliereController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOFiliere daoF = new DAOFiliere();
		//Si on ne recoit pas d'id => findAll
		if(request.getParameter("id")==null) 
		{
			
			List<Filiere> filieres = daoF.findAll();
			request.setAttribute("filieres", filieres);
			this.getServletContext().getRequestDispatcher("/filieres.jsp").forward(request, response);	
		}
		else 
		{
		
			//pas de param delete => findById
			if(request.getParameter("delete")==null) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Filiere f = daoF.findById(id);
				request.setAttribute("filiere", f);
				this.getServletContext().getRequestDispatcher("/updateFiliere.jsp").forward(request, response);	
			}
			//param id + delete => delete
			else {}
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Si pas d'id en param => insert
		if(request.getParameter("id")==null) 
		{
			
		}
		//update"
		else 
		{
			
		}
	}

}
