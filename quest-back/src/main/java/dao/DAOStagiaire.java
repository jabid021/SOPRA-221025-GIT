package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Stagiaire;

public class DAOStagiaire implements IDAOStagiaire {

	@Override
	public Stagiaire findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Stagiaire stagiaire = em.find(Stagiaire.class, id);
		em.close();
		return stagiaire;
	}

	@Override
	public List<Stagiaire> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Stagiaire> stagiaires = em.createQuery("from Stagiaire").getResultList();
		em.close();
		return stagiaires;
	}

	@Override
	public Stagiaire save(Stagiaire s) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			s=em.merge(s);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
		return s;
	}

	@Override
	public void delete(Stagiaire s) {
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			s=em.merge(s);
			em.remove(s);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
	}

	@Override
	public List<Stagiaire> findAllByFiliere(Integer idFiliere) {
		//CODER ICI 
		return null;
	}

}
