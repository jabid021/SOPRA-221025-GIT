package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Patient;

public class DAOPatient implements IDAOPatient {

	@Override
	public Patient findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Patient patient = em.find(Patient.class, id);
		em.close();
		return patient;
	}

	@Override
	public List<Patient> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Patient> patients = em.createQuery("from Patient").getResultList();
		em.close();
		return patients;
	}

	@Override
	public Patient save(Patient p) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			p=em.merge(p);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
		return p;
	}

	@Override
	public void delete(Patient p) {
	
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		try 
		{
			em.getTransaction().begin();
			p=em.merge(p);
			em.remove(p);
			em.getTransaction().commit();
		}
		catch(Exception e){e.printStackTrace();}
		em.close();
	}

}
