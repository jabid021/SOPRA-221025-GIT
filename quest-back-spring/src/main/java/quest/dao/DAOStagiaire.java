package quest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import quest.model.Stagiaire;

@Repository
@Transactional(readOnly = true)
public class DAOStagiaire implements IDAOStagiaire {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Stagiaire findById(Integer id) {
		return em.find(Stagiaire.class, id);
	}

	@Override
	public List<Stagiaire> findAll() {
		return em.createQuery("from Stagiaire", Stagiaire.class).getResultList();
	}

	@Override
	@Transactional(readOnly = false)
	public Stagiaire save(Stagiaire s) {
		return em.merge(s);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Stagiaire s) {
		em.remove(em.merge(s));
	}

	@Override
	public List<Stagiaire> findAllByFiliere(Integer idFiliere) {
		List<Stagiaire> stagiaires = em.createQuery("SELECT s from Stagiaire s where s.filiere.id=:id", Stagiaire.class)
				.setParameter("id", idFiliere).getResultList();
		return stagiaires;
	}

}
