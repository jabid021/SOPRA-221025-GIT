package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import quest.model.Filiere;

public interface IDAOFiliere extends JpaRepository<Filiere,Integer> {

//	public List<Filiere> findAllByDateFilter(LocalDate filter);
//	public List<Filiere> findAllWithStagiaires();
}
