package servletV1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jdbc.DAOPatientJDBC;
import model.Patient;

@WebServlet("/demo")
public class demoServlet extends HttpServlet {
	
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOPatientJDBC daoP = new DAOPatientJDBC();
		List<Patient> patients = daoP.findAll();
		
		response.getWriter().println("<html>");
			response.getWriter().println("<body>");
				response.getWriter().println("<table>");
					response.getWriter().println("<tr>");
					response.getWriter().println("<th>ID</th><th>Nom</th><th>Prenom</th>");
					response.getWriter().println("</tr>");
					for(Patient p : patients) 
					{
						response.getWriter().println("<tr><td>"+p.getId()+"</td><td>"+p.getNom()+"</td><td>"+p.getPrenom()+"</td></tr>");
					}
					
				response.getWriter().println("</table>");
			response.getWriter().println("</body>");
		response.getWriter().println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
