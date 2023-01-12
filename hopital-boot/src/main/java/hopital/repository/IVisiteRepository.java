package hopital.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hopital.model.Visite;


public interface IVisiteRepository extends JpaRepository<Visite, Integer> {
	
	@Query("Select v from Visite v where v.patient.id=?1")
	List<Visite> findAllByPatient(Integer PatientId);
	
}
