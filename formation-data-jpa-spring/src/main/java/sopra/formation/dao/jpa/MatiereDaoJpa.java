package sopra.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.dao.IMatiereDao;
import sopra.formation.model.Matiere;

@Repository
@Transactional
public class MatiereDaoJpa implements IMatiereDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Matiere> findAll() {
		TypedQuery<Matiere> query = em.createQuery("from Matiere", Matiere.class);

		return query.getResultList();
	}

	@Override
	public Matiere find(Long id) {
		return em.find(Matiere.class, id);
	}

	@Override
	public Matiere save(Matiere obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Matiere obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public List<Matiere> findAllByNom(String nom) {
		TypedQuery<Matiere> query = em.createNamedQuery("Matiere.findAllByNom", Matiere.class);

		query.setParameter("leNom", nom);

		return query.getResultList();
	}

	@Override
	public List<Matiere> findAllByDuree(int duree) {
		TypedQuery<Matiere> query = em.createNamedQuery("Matiere.findAllByDuree", Matiere.class);

		query.setParameter("laDuree", duree);

		return query.getResultList();
	}

}
