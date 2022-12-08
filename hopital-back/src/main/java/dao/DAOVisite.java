package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Visite;

public class DAOVisite implements IDAOVisite {

	@Override
	public Visite findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class, id);
		em.close();
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Visite> visites = em.createQuery("from Visite").getResultList();
		em.close();
		return visites;
	}

	@Override
	public Visite save(Visite s) {
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
	public void delete(Visite v) {
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			v=em.merge(v);
			em.remove(v);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
	}

	@Override
	public List<Visite> findAllByIdPatient(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
