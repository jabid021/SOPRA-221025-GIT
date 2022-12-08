package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Sorcier;

public class DAOSorcier implements IDAOSorcier {

	@Override
	public Sorcier findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Sorcier sorcier = em.find(Sorcier.class, id);
		em.close();
		return sorcier;
	}

	@Override
	public List<Sorcier> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Sorcier> sorciers = em.createQuery("from Sorcier").getResultList();
		em.close();
		return sorciers;
	}

	@Override
	public Sorcier save(Sorcier s) {
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
	public void delete(Sorcier s) {
	
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

}
