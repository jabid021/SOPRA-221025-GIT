package poudlard.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import poudlard.config.ApplicationConfig;
import poudlard.model.Baguette;
import poudlard.model.Competence;
import poudlard.model.Eleve;
import poudlard.model.Maison;
import poudlard.model.Patronus;
import poudlard.model.Professeur;
import poudlard.model.Sort;
import poudlard.model.Stats;
import poudlard.repository.IBaguetteRepository;
import poudlard.repository.ICompetenceRepository;
import poudlard.repository.IMaisonRepository;
import poudlard.repository.ISorcierRepository;
import poudlard.repository.ISortRepository;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:/application-context.xml")
@ContextConfiguration(classes = ApplicationConfig.class)
public class TestPopulate {
	@Autowired
	private IBaguetteRepository baguetteRepo;
	@Autowired
	private ICompetenceRepository competenceRepo;
	@Autowired
	private IMaisonRepository maisonRepo;
	@Autowired
	private ISorcierRepository sorcierRepo;
	@Autowired
	private ISortRepository sortRepo;

	@Test
	public void populateData() {
		Professeur p1 = new Professeur("Dumbledore", "Albus", Patronus.Phoenix, new Stats(9001, 9001), "Metamorphose");
		p1 = sorcierRepo.save(p1);

		Professeur p2 = new Professeur("sev ", "Rogue", Patronus.Coccinelle, new Stats(50, 90), "PAS GENTIL");
		p2 = sorcierRepo.save(p2);

		Maison m1 = new Maison("Gryffondor", p1);
		m1 = maisonRepo.save(m1);

		Maison m2 = new Maison("Serpentard", p2);
		m2 = maisonRepo.save(m2);

		Baguette b1 = new Baguette("baguette1");
		b1 = baguetteRepo.save(b1);

		Baguette b2 = new Baguette("baguette2");
		b2 = baguetteRepo.save(b2);

		Sort spell1 = new Sort("Lumos", 0);
		spell1 = sortRepo.save(spell1);

		Sort spell2 = new Sort("Wingardium LeviOOOsa", 10);
		spell2 = sortRepo.save(spell2);

		Stats stat1 = new Stats(99, 99);

		Eleve s1 = new Eleve(null, "Harry", 1, Patronus.Cerf, stat1, m1);
		s1.setBaguette(b1);
		s1.setRang(1);
		s1 = sorcierRepo.save(s1);

		Eleve s2 = new Eleve("Weasley", "Ron", 1, Patronus.Chien, new Stats(20, 15), m1);
		s2 = sorcierRepo.save(s2);

		Eleve s3 = new Eleve("Granger", "Hermione", 1, Patronus.Loutre, new Stats(50, 50), m1);
		s3 = sorcierRepo.save(s3);

		Competence comp1 = new Competence(4, s1, spell1);
		comp1 = competenceRepo.save(comp1);
		Competence comp2 = new Competence(5, s3, spell2);
		comp2 = competenceRepo.save(comp2);
	}

}
