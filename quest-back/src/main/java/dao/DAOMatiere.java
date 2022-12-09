package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Matiere;

public class DAOMatiere implements IDAOMatiere {

	@Override
	public Matiere findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Matiere matiere = em.find(Matiere.class, id);
		em.close();
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Matiere> matieres = em.createQuery("from Matiere").getResultList();
		em.close();
		return matieres;
	}

	@Override
	public Matiere save(Matiere m) {
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
	public void delete(Matiere m) {
	
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
