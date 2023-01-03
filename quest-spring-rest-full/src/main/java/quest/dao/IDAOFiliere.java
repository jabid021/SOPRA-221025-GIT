package quest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere,Integer> {

//	public List<Filiere> findAllByDateFilter(LocalDate filter);
	
	@Query("select distinct f from Filiere f left join fetch f.stagiaires where f.id = :id")
	public Optional<Filiere> findByIdWithStagiaires(@Param("id") Integer id);
}
