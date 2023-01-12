package hopital.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import hopital.model.Visite;


public interface IVisiteRepository extends JpaRepository<Visite, Integer> {
	
	
	
}
