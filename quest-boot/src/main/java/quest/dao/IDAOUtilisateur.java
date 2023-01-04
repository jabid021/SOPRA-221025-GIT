package quest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import quest.model.Utilisateur;

public interface IDAOUtilisateur extends JpaRepository<Utilisateur, Integer>{
	Optional<Utilisateur> findByIdentifiant(String identifiant);
}
