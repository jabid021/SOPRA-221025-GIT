package hopital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hopital.model.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
