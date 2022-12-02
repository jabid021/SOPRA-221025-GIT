package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOVehicule;
import model.Compte;
import model.Vehicule;

@WebServlet("/vehicule")
public class VehiculeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Permet d'afficher la liste des vehicules d'un utilisateur : 
		DAOVehicule daoV = new DAOVehicule();
		
		int id = ((Compte) request.getSession().getAttribute("compte")).getId();
		//Chercher la liste de vehicules de l'utilisateur 
		List<Vehicule> vehicules = daoV.findAllByUtilisateur(id);
		request.setAttribute("vehicules", vehicules);
		this.getServletContext().getRequestDispatcher("/WEB-INF/mesVehicules.jsp").forward(request, response);
		//////
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
