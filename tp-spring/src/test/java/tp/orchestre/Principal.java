package tp.orchestre;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		
		
		// IMusicien musicien = (IMusicien) context.getBean("guitariste"); // recherche de bean par identifiant
		
//		IMusicien musicien = context.getBean("guitariste", IMusicien.class); // recherche de bean par type et identifiant
		
		IMusicien musicien = context.getBean(IMusicien.class); // recherche de bean par type (resultat doit être unique)
				
		musicien.jouer();

		
		
		context.close();
	}

}
