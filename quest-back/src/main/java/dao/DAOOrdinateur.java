package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Ordinateur;

public class DAOOrdinateur implements IDAOOrdinateur {

	@Override
	public Ordinateur findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ordinateur ordinateur = em.find(Ordinateur.class, id);
		em.close();
		return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Ordinateur> ordinateurs = em.createQuery("from Ordinateur").getResultList();
		em.close();
		return ordinateurs;
	}

	@Override
	public Ordinateur save(Ordinateur o) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			o=em.merge(o);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
		return o;
	}

	@Override
	public void delete(Ordinateur o) {
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			o=em.merge(o);
			em.remove(o);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
	}

}
