package poudlard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poudlard.model.Eleve;
import poudlard.model.Professeur;
import poudlard.model.Sorcier;

public interface ISorcierRepository extends JpaRepository<Sorcier, Integer> {

	@Query("select e from Eleve e")
	List<Eleve> findAllEleve();

	@Query("select p from Professeur p")
	List<Professeur> findAllProfesseur();
}
