package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Maison;

public class DAOMaison implements IDAOMaison {

	@Override
	public Maison findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Maison maison = em.find(Maison.class, id);
		em.close();
		return maison;
	}

	@Override
	public List<Maison> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Maison> maisons = em.createQuery("from Maison").getResultList();
		em.close();
		return maisons;
	}

	@Override
	public Maison save(Maison m) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			m=em.merge(m);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
		return m;
	}

	@Override
	public void delete(Maison m) {
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			m=em.merge(m);
			em.remove(m);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
	}

}
