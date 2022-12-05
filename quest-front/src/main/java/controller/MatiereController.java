package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOMatiere;
import model.Matiere;

@WebServlet("/matiere")
public class MatiereController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOMatiere daoM = new DAOMatiere();
		if(request.getParameter("id")==null) 
		{
			
			List<Matiere> matieres = daoM.findAll();
			request.setAttribute("matieres", matieres);
			this.getServletContext().getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request, response);	
		}
		else 
		{
			if(request.getParameter("delete")==null) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				Matiere m = daoM.findById(id);
				request.setAttribute("matiere", m);
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateMatiere.jsp").forward(request, response);	
			}
			else 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				daoM.delete(id);
				response.sendRedirect("matiere");
			}
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOMatiere daoM = new DAOMatiere();
		
		if(request.getParameter("id")==null) 
		{
			String libelle = request.getParameter("libelle");
			int quest = Integer.parseInt(request.getParameter("quest"));
			Matiere m = new Matiere(libelle, quest);
			daoM.insert(m);
			response.sendRedirect("matiere");
		}
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String libelle = request.getParameter("libelle");
			int quest = Integer.parseInt(request.getParameter("quest"));
			Matiere m = new Matiere(id,libelle, quest);
			daoM.update(m);
			response.sendRedirect("matiere");
		}
	}


}
