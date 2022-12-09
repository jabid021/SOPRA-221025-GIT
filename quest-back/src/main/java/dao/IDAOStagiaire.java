package dao;

import java.util.List;

import model.Stagiaire;

public interface IDAOStagiaire extends IDAO<Stagiaire,Integer> {

	
	public List<Stagiaire> findAllByFiliere(Integer idFiliere);
}
