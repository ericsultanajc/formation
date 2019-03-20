package sopra.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.dao.IEleveFormateurDao;
import sopra.formation.model.EleveFormateur;

@Repository
@Transactional
public class EleveFormateurDaoJpa implements IEleveFormateurDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<EleveFormateur> findAll() {
		TypedQuery<EleveFormateur> query = em.createQuery("from EleveFormateur", EleveFormateur.class);

		return query.getResultList();
	}

	@Override
	public EleveFormateur find(Long id) {
		return em.find(EleveFormateur.class, id);
	}

	@Override
	public EleveFormateur save(EleveFormateur obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(EleveFormateur obj) {
		em.remove(em.merge(obj));
	}

}
