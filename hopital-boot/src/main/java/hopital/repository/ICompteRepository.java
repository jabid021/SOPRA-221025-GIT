package hopital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hopital.model.Compte;
import hopital.model.Inscription;
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
	
	@Query("from Inscription")
	List<Inscription> findAllInscription();
	
	
	@Query("SELECT i from Inscription i where i.login=:login and i.mdp = :mdp and i.choix= :choix")
	public List<Inscription> findAllByInscriptionChoix(String choix); // par annotation @Query
}
