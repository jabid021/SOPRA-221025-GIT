package dao;

import java.time.LocalDate;
import java.util.List;

import model.Filiere;

public interface IDAOFiliere extends IDAO<Filiere,Integer> {

	public List<Filiere>findAllByDateFilter(LocalDate filter);
}
