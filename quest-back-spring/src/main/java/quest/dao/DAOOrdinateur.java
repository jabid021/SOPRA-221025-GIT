package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Ordinateur;

@Repository
@Transactional(readOnly = true)
public class DAOOrdinateur implements IDAOOrdinateur {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Ordinateur findById(Integer id) {
		return em.find(Ordinateur.class, id);
	}

	@Override
	public List<Ordinateur> findAll() {
		return em.createQuery("from Ordinateur", Ordinateur.class).getResultList();
	}

	@Override
	@Transactional(readOnly = false)
	public Ordinateur save(Ordinateur o) {
		return em.merge(o);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Ordinateur o) {
		em.remove(em.merge(o));
	}

}
