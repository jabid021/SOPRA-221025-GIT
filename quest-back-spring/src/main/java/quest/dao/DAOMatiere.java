package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Matiere;

@Repository
@Transactional(readOnly = true)
public class DAOMatiere implements IDAOMatiere {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Matiere findById(Integer id) {
		return em.find(Matiere.class, id);
	}

	@Override
	public List<Matiere> findAll() {
		return em.createQuery("from Matiere", Matiere.class).getResultList();
	}

	@Override
	@Transactional(readOnly = false)
	public Matiere save(Matiere m) {
		return em.merge(m);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Matiere m) {
		em.remove(em.merge(m));
	}

}
