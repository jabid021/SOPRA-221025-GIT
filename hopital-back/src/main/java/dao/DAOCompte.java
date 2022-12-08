package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Compte;

public class DAOCompte implements IDAOCompte {

	@Override
	public Compte findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Compte compte = em.find(Compte.class, id);
		em.close();
		return compte;
	}

	@Override
	public List<Compte> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Compte> comptes = em.createQuery("from Compte").getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Compte save(Compte c) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			c=em.merge(c);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
		return c;
	}

	@Override
	public void delete(Compte c) {
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			c=em.merge(c);
			em.remove(c);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
	}

	@Override
	public Compte seConnecter(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
