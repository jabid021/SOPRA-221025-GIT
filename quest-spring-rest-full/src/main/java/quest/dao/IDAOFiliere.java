package quest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere,Integer> {

//	public List<Filiere> findAllByDateFilter(LocalDate filter);
	
	@Query("select distinct f from Filiere f left join fetch f.stagiaires where f.id = :id")
	public Optional<Filiere> findByIdWithStagiaires(@Param("id") Integer id);
	
	@Query("select distinct f from Filiere f left join fetch f.matieres where f.id = :id")
	public Optional<Filiere> findByIdWithMatieres(@Param("id") Integer id);
	
//	@Query("select distinct f from Filiere f left join fetch f.matieres left join fetch f.stagiaires where f.id = :id")
	@Query("select distinct f from Filiere f left join fetch f.matieres where f.id = :id")
	public Optional<Filiere> findByIdWithAll(@Param("id") Integer id);
	
	@Query("select f from Filiere f join f.matieres m where m.id = :id")
	public List<Filiere> findAllByMatiere(@Param("id") Integer id);
}
