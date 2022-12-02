package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOPatient;
import model.Patient;

@WebServlet("/patient")
public class PatientControler extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//On recup l'id dans l'url (parametres de l'url"
		int id = Integer.parseInt(request.getParameter("id"));

		//On fait nos traitements pour recup les infos (le patient x)
		DAOPatient daoP = new DAOPatient();

		Patient p = daoP.findById(id);
		
		//On va attacher à la request le patient trouvé en bdd
		request.setAttribute("patient", p);
		//on redirige notre request (avec le patient x) vers la page patient.jsp
		this.getServletContext().getRequestDispatcher("/WEB-INF/patient.jsp").forward(request, response);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
