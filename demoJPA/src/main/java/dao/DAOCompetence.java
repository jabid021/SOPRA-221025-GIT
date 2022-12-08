package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Competence;

public class DAOCompetence implements IDAOCompetence {

	@Override
	public Competence findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Competence competence = em.find(Competence.class, id);
		em.close();
		return competence;
	}

	@Override
	public List<Competence> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Competence> competences = em.createQuery("from Competence").getResultList();
		em.close();
		return competences;
	}

	@Override
	public Competence save(Competence c) {
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
	public void delete(Competence c) {
	
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

}
