package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Singleton;
import model.Baguette;

public class DAOBaguette implements IDAOBaguette {

	@Override
	public Baguette findById(Integer id) {
		Baguette baguette = null;
		EntityManager em = null;
		
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			baguette = em.find(Baguette.class, id);
		}
		catch(Exception e) {e.printStackTrace();}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		
		return baguette;
	}

	@Override
	public List<Baguette> findAll() {
		EntityManager em = null;
		List<Baguette> baguettes=null;
		
		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			baguettes = em.createQuery("from Baguette").getResultList();
		}
		catch(Exception e) {e.printStackTrace();}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		return baguettes;
	}

	@Override
	public Baguette save(Baguette b) {
		EntityManager em = null;
		EntityTransaction tx =null;
		
		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();
			b=em.merge(b);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if(tx !=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
		return b;
	}

	@Override
	public void delete(Baguette b) {
	
		EntityManager em = null;
		EntityTransaction tx =null;
		try 
		{
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();
			b=em.merge(b);
			em.remove(b);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			if(tx !=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
	}

}