package quest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import quest.model.Stagiaire;

public interface IDAOStagiaire extends JpaRepository<Stagiaire, Integer> {

	@RestResource(path = "by-nom-and-prenom")
	public List<Stagiaire> findByNomAndPrenom(String nom, String prenom); // par convention de nommage

	@Query("SELECT s from Stagiaire s where s.filiere.id = :id")
	public List<Stagiaire> findAllByFiliere(@Param("id") Integer idFiliere); // par annotation @Query

	@Query("SELECT s from Stagiaire s where s.filiere.libelle = ?1")
	public List<Stagiaire> findAllByFiliereLibelle(String libelle); // par annotation @Query
	
	public Stagiaire searchByEmail(@Param("email") String email); // par annotation @NamedQuery dans l'entité
}

