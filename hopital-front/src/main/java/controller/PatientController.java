package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.Singleton;
import dao.IDAOPatient;
import dao.IDAOVisite;
import model.Patient;
import model.Visite;

@WebServlet("/patient")
public class PatientController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On recup l'id dans l'url (parametres de l'url"
		int id = Integer.parseInt(request.getParameter("id"));

		//On fait nos traitements pour recup les infos (le patient x)
		IDAOPatient daoP = Singleton.getInstance().getDaoPatient();

		Patient p = daoP.findById(id);
		
		//On va attacher à la request le patient trouvé en bdd
		request.setAttribute("patient", p);
		//on redirige notre request (avec le patient x) vers la page patient.jsp
		this.getServletContext().getRequestDispatcher("/WEB-INF/patient.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		IDAOVisite daoV = Singleton.getInstance().getDaoVisite();
		
		List<Visite> listVisites  = daoV.findAllByIdPatient(id);
		
		request.setAttribute("visites", listVisites);
		this.getServletContext().getRequestDispatcher("/WEB-INF/showVisites.jsp").forward(request, response);

	}

}
