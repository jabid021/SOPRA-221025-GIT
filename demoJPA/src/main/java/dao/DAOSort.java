package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Sort;

public class DAOSort implements IDAOSort {

	@Override
	public Sort findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Sort sort = em.find(Sort.class, id);
		em.close();
		return sort;
	}

	@Override
	public List<Sort> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Sort> sorts = em.createQuery("from Sort").getResultList();
		em.close();
		return sorts;
	}

	@Override
	public Sort save(Sort s) {
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
	public void delete(Sort s) {
	
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
