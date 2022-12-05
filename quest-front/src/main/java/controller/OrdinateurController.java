package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOOrdinateur;
import model.Ordinateur;

@WebServlet("/ordinateur")
public class OrdinateurController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOOrdinateur daoO = new DAOOrdinateur();
		if(request.getParameter("id")==null) 
		{
			
			List<Ordinateur> ordinateurs = daoO.findAll();
			request.setAttribute("ordinateurs", ordinateurs);
			this.getServletContext().getRequestDispatcher("/ordinateurs.jsp").forward(request, response);	
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Ordinateur o = daoO.findById(id);
				request.setAttribute("Ordinateur", o);
				this.getServletContext().getRequestDispatcher("/updateOrdinateur.jsp").forward(request, response);	
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
