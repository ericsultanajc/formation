package sopra.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.dao.IPersonneDao;
import sopra.formation.model.Eleve;
import sopra.formation.model.Formateur;
import sopra.formation.model.Formation;
import sopra.formation.model.Personne;

@Repository
@Transactional
public class PersonneDaoJpa implements IPersonneDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Personne> findAll() {
		TypedQuery<Personne> query = em.createQuery("select p from Personne p", Personne.class);

		return query.getResultList();
	}

	@Override
	public Personne find(Long id) {
		return em.find(Personne.class, id);
	}

	@Override
	public Personne save(Personne obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Personne obj) {
		em.remove(em.merge(obj));
	}

	@Override
	public List<Eleve> findAllEleve() {
		TypedQuery<Eleve> query = em.createQuery("select e from Eleve e", Eleve.class);

		return query.getResultList();
	}

	@Override
	public List<Formateur> findAllFormateur() {
		TypedQuery<Formateur> query = em.createQuery("select f from Formateur f", Formateur.class);

		return query.getResultList();
	}

	@Override
	public List<Formateur> findAllFormateurByMatiere(Long matiereId) {
		Query query = em.createQuery("select f from Formateur f join f.matieres m where m.id = :idMatiere");

		query.setParameter("idMatiere", matiereId);

		return query.getResultList();
	}

	@Override
	public List<Personne> findAllByFormation(Formation formation) {
		TypedQuery<Personne> query = em.createQuery("select p from Personne p where p.formation = :form",
				Personne.class);

		query.setParameter("form", formation);

		return query.getResultList();
	}

	@Override
	public List<Eleve> findAllEleveByFormateur(Long formateurId) {
//			TypedQuery<Eleve> query = em.createQuery("select e from Eleve e join e.formateurs ef where ef.formateur.id = :formateurId", Eleve.class);

		TypedQuery<Eleve> query = em.createQuery(
				"select ef.eleve from EleveFormateur ef where ef.formateur.id = :formateurId", Eleve.class);

		query.setParameter("formateurId", formateurId);

		return query.getResultList();
	}

}
