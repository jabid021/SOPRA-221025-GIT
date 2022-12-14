package quest.test;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import quest.config.ApplicationConfig;
import quest.dao.IDAOFiliere;
import quest.model.Filiere;

public class TestSpring {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		
		IDAOFiliere daoFiliere = context.getBean(IDAOFiliere.class);
		
		Filiere filiere = new Filiere(null, LocalDate.of(2022, Month.OCTOBER, 25), LocalDate.of(2023, Month.JANUARY, 20));
		
		try {
		filiere = daoFiliere.save(filiere);
		} catch (DataAccessException dae) {
			
		}
		
		
		context.close();
	}

}
