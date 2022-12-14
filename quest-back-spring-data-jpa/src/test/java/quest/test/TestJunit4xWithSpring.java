package quest.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOStagiaire;
import quest.model.Filiere;
import quest.model.Stagiaire;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/application-context.xml")
//@ContextConfiguration(classes = ApplicationConfig.class)
public class TestJunit4xWithSpring {
	@Autowired
	private IDAOFiliere daoFiliere;
	@Autowired
	private IDAOStagiaire daoStagiaire;

	@Test
	public void stagiaireFindAllByFiliere() {
		// ARRANGE
		Filiere javaSpring = new Filiere("Java Spring", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-05-01"));
		javaSpring = daoFiliere.save(javaSpring);

		Filiere devops = new Filiere("DEVOPS", LocalDate.parse("2022-02-05"), LocalDate.parse("2023-06-01"));
		devops = daoFiliere.save(devops);

		Stagiaire thomas = new Stagiaire("OURLIAC", "Thomas", "thomas@gmail.com", javaSpring);
		thomas = daoStagiaire.save(thomas);

		Stagiaire manon = new Stagiaire("BONNIN", "Manon", "manon@gmail.com", javaSpring);
		manon = daoStagiaire.save(manon);

		Stagiaire ilham = new Stagiaire("BOUTOUAL", "Ilham", "ilham@gmail.com", devops);
		ilham = daoStagiaire.save(ilham);

		// ACT
		List<Stagiaire> stagiaires = daoStagiaire.findAllByFiliere(javaSpring.getId());

		// ASSERT
		Assert.assertEquals(2, stagiaires.size());

	}

	@Test
	public void creationStagiaire() {
		// ARRANGE
		Filiere javaSpring = new Filiere("Java Spring", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-05-01"));
		javaSpring = daoFiliere.save(javaSpring);

		// ACT
		Stagiaire thomas = new Stagiaire("OURLIAC", "Thomas", "thomas@gmail.com", javaSpring);
		thomas = daoStagiaire.save(thomas);

		// ASSERT
		Optional<Stagiaire> optThomasFind = daoStagiaire.findById(thomas.getId());
		Assert.assertTrue(optThomasFind.isPresent());
		Stagiaire thomasFind = optThomasFind.get();
		Assert.assertEquals("OURLIAC", thomasFind.getNom());
		Assert.assertEquals("Thomas", thomasFind.getPrenom());
		Assert.assertEquals("thomas@gmail.com", thomasFind.getEmail());
		Assert.assertEquals(javaSpring.getId(), thomasFind.getFiliere().getId());
	}

}
