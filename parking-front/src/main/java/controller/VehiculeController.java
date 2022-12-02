package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOVehicule;
import model.Carburant;
import model.Compte;
import model.Moto;
import model.Taille;
import model.Utilisateur;
import model.Vehicule;
import model.Voiture;

@WebServlet("/vehicule")
public class VehiculeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOVehicule daoV = new DAOVehicule();
		
		
		//S'il n'y a pas d'id en parametre, c'est qu'on veut afficher la liste complete des vehicules => findAll sur la page mesVehicules
		if(request.getParameter("id")==null) 
		{
			int idCompte = ((Compte) request.getSession().getAttribute("compte")).getId();
			//Chercher la liste de vehicules de l'utilisateur 
			List<Vehicule> vehicules = daoV.findAllByUtilisateur(idCompte);
			request.setAttribute("vehicules", vehicules);
			this.getServletContext().getRequestDispatcher("/WEB-INF/mesVehicules.jsp").forward(request, response);

		}
		else 
		{
			int id=Integer.parseInt(request.getParameter("id"));
			
			//S'il y a les parametres id et delete, c'est qu'on veut supprimer un vehicule, sinon affiche la page d'update
			if(request.getParameter("delete")!=null) 
			{
				daoV.delete(id);
				response.sendRedirect("vehicule");
			}
			else 
			{	
				Vehicule v = daoV.findById(id);
				request.setAttribute("vehicule", v);
				request.setAttribute("carburants", Carburant.values());
				this.getServletContext().getRequestDispatcher("/WEB-INF/updateVehicule.jsp").forward(request, response);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOVehicule daoV = new DAOVehicule();
		
		Utilisateur utilisateur = ((Utilisateur) request.getSession().getAttribute("compte"));
		Vehicule v = null;
		String mode=request.getParameter("mode");
		String marque=request.getParameter("marque");
		String plaque=request.getParameter("plaque");
		List<Carburant> carburants = new ArrayList();
		
		for(Carburant c : Carburant.values()) 
		{
			if(request.getParameter(c.toString())!=null) 
			{
				carburants.add(c);
			}
		}
		String typeVehicule=request.getParameter("type_vehicule");
		
		
		if(typeVehicule.equals("Voiture")) 
		{
			int nbPlace = Integer.parseInt(request.getParameter("nbPlace"));
			boolean decapotable = (request.getParameter("decapotable").equals("oui"))?true:false;
			String taille=request.getParameter("taille");
			v = new Voiture(marque, plaque, Taille.valueOf(taille), utilisateur, nbPlace, decapotable);
			v.setCarburants(carburants);
		}
		else 
		{
			int roues = Integer.parseInt(request.getParameter("roues"));
			v=new Moto(marque, plaque, utilisateur, roues);
			v.setCarburants(carburants);
		}
	
		
		if(mode.equals("insert")) 
		{
			daoV.insert(v);
		}
		else 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			v.setId(id);
			daoV.update(v);
		}
		
		response.sendRedirect("vehicule");
		
	}
}
