package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Filiere;

public class DAOFiliere implements IDAOFiliere {

	@Override
	public Filiere findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Filiere filiere = em.find(Filiere.class, id);
		em.close();
		return filiere;
	}

	@Override
	public List<Filiere> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Filiere> filieres = em.createQuery("from Filiere").getResultList();
		em.close();
		return filieres;
	}

	@Override
	public Filiere save(Filiere f) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			f=em.merge(f);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
		return f;
	}

	@Override
	public void delete(Filiere f) {
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			f=em.merge(f);
			em.remove(f);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
	}

	@Override
	public List<Filiere> findAllByDateFilter(LocalDate filter) {
		//CODER ICI 
		
		return null;
	}

}
