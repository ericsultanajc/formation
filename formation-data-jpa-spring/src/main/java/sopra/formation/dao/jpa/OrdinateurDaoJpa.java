package sopra.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.dao.IOrdinateurDao;
import sopra.formation.model.Ordinateur;

@Repository // @Component spécialisé pour les DAO (ou Repository)
@Transactional
public class OrdinateurDaoJpa implements IOrdinateurDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Ordinateur> findAll() {
		TypedQuery<Ordinateur> query = em.createQuery("from Ordinateur", Ordinateur.class);
		return query.getResultList();
	}

	@Override
	public Ordinateur find(Long id) {
		return em.find(Ordinateur.class, id);
	}

	@Override
	public Ordinateur save(Ordinateur obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Ordinateur obj) {
		em.remove(em.merge(obj));
	}
}
