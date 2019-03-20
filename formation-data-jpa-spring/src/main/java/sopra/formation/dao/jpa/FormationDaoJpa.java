package sopra.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.dao.IFormationDao;
import sopra.formation.model.Formation;

@Repository // @Component spécialisé pour les DAO (ou Repository)
@Transactional
public class FormationDaoJpa implements IFormationDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Formation> findAll() {
		TypedQuery<Formation> query = em.createQuery("from Formation", Formation.class);
		return query.getResultList();
	}

	@Override
	public Formation find(Long id) {
		return em.find(Formation.class, id);

	}

	@Override
	public Formation save(Formation obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Formation obj) {
		em.remove(em.merge(obj));
	}

}
