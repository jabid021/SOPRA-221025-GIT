package quest.dao;

import java.time.LocalDate;
import java.util.List;

import quest.model.Filiere;

public interface IDAOFiliere extends IDAO<Filiere,Integer> {

	public List<Filiere>findAllByDateFilter(LocalDate filter);
	public List<Filiere> findAllWithStagiaires();
}
