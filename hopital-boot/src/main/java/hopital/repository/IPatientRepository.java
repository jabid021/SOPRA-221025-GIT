package hopital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hopital.model.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {
	
	@Query("Select p from Patient p where p.numeroSecuriteSociale=?1")
	public Optional<Patient> findBySS(String numeroSecuriteSociale);

	
	
	
}
