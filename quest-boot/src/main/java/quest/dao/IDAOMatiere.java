package quest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import quest.model.Matiere;

public interface IDAOMatiere extends JpaRepository<Matiere, Integer> {

}
