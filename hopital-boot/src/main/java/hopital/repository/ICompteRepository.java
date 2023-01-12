package hopital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Secretaire;

public interface ICompteRepository extends JpaRepository<Compte, Integer>{

	@Query("from Medecin")
	List<Medecin> findAllMedecin();
	
	@Query("from Secretaire")
	List<Secretaire> findAllSecretaire();
	
	@Query("from Medecin m where m.id = ?1")
	Optional<Medecin> findMedecinById(Integer id);
	
	@Query("from Secretaire s where s.id = ?1")
	Optional<Secretaire> findSecretaireById(Integer id);
	

	@Query("SELECT c from Compte c where c.login = :login and c.password =:password")
	Optional<Compte>findByLoginAndPassword(@Param("login") String login, @Param("password") String password);



	 
}
	 

	


