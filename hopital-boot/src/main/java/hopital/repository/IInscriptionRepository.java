package hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hopital.model.Inscription; 

public interface IInscriptionRepository extends JpaRepository<Inscription,Integer>{
	 
}
