package hopital.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hopital.model.Visite;

public interface IVisiteRepository extends JpaRepository<Visite, Integer> {

	@Query("select distinct v from Visite v left join fetch v.medecin where v.id = :id")
	public Optional<Visite> findByIdWithMedecin(@Param("id") Integer id);
	
	@Query("select distinct v from Visite v left join fetch v.patient where v.id = :id")
	public Optional<Visite> findByIdWithPatient(@Param("id") Integer id);
}
