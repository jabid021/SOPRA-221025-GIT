package quest.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Filiere;

@Repository
@Transactional(readOnly = true)
public class DAOFiliere implements IDAOFiliere {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Filiere findById(Integer id) {
		return em.find(Filiere.class, id);
	}

	@Override
	public List<Filiere> findAll() {
		return em.createQuery("from Filiere", Filiere.class).getResultList();
	}

	@Override
	@Transactional(readOnly = false)
	public Filiere save(Filiere f) {
		return em.merge(f);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Filiere f) {
		em.remove(em.merge(f));
	}

	@Override
	public List<Filiere> findAllByDateFilter(LocalDate filter) {
		List<Filiere> filieres = em.createQuery(
				"SELECT distinct f from Filiere f  left join fetch f.stagiaires where :filter BETWEEN f.debut and f.fin",
				Filiere.class).setParameter("filter", filter).getResultList();
		return filieres;
	}

	@Override
	public List<Filiere> findAllWithStagiaires() {
		List<Filiere> filieres = em
				.createQuery("SELECT distinct f from Filiere f left join fetch f.stagiaires", Filiere.class)
				.getResultList();
		return filieres;
	}

}
