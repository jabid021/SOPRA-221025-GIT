package quest;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOOrdinateur;
import quest.dao.IDAOStagiaire;
import quest.model.Filiere;
import quest.model.Matiere;
import quest.model.Ordinateur;
import quest.model.Stagiaire;

@SpringBootTest
class QuestBootApplicationTests {
	
	@Autowired
	private IDAOFiliere daoFiliere;
	@Autowired
	private IDAOStagiaire daoStagiaire;
	@Autowired
	private IDAOMatiere daoMatiere;
	@Autowired
	private IDAOOrdinateur daoOrdinateur;

	@Test
	void contextLoads() {
		Matiere html = new Matiere("HTML", 3345);
		html = daoMatiere.save(html);
		
		Matiere javascript = new Matiere("JAVASCRIPT", 5245);
		javascript = daoMatiere.save(javascript);
		
		Matiere jpa = new Matiere("JPA", 4477);
		jpa = daoMatiere.save(jpa);
		
		Matiere ansible = new Matiere("ANSIBLE", 8888);
		ansible = daoMatiere.save(ansible);
		
		Filiere javaSpring = new Filiere("Java Spring", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-05-01"));
		javaSpring.getMatieres().add(html);
		javaSpring.getMatieres().add(javascript);
		javaSpring.getMatieres().add(jpa);
		javaSpring = daoFiliere.save(javaSpring);

		Filiere devops = new Filiere("DEVOPS", LocalDate.parse("2022-02-05"), LocalDate.parse("2023-06-01"));
		devops.getMatieres().add(javascript);
		devops.getMatieres().add(ansible);
		devops = daoFiliere.save(devops);

		Stagiaire thomas = new Stagiaire("OURLIAC", "Thomas", "thomas@gmail.com", javaSpring);
		thomas = daoStagiaire.save(thomas);

		Stagiaire manon = new Stagiaire("BONNIN", "Manon", "manon@gmail.com", javaSpring);
		manon = daoStagiaire.save(manon);

		Stagiaire ilham = new Stagiaire("BOUTOUAL", "Ilham", "ilham@gmail.com", devops);
		ilham = daoStagiaire.save(ilham);
		
		Ordinateur ordi1 = new Ordinateur("ASUS", 16, ilham);
		ordi1 = daoOrdinateur.save(ordi1);
		
		Ordinateur ordi2 = new Ordinateur("HP", 32, thomas);
		ordi2 = daoOrdinateur.save(ordi2);
		
	}

}
