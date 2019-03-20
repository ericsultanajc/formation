package sopra.formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.formation.Application;
import sopra.formation.dao.IEleveFormateurDao;
import sopra.formation.model.EleveFormateur;

public class EleveFormateurDaoJpa implements IEleveFormateurDao {

	@Override
	public List<EleveFormateur> findAll() {
		List<EleveFormateur> liste = new ArrayList<EleveFormateur>();

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			TypedQuery<EleveFormateur> query = em.createQuery("from EleveFormateur", EleveFormateur.class);
			
			liste = query.getResultList();
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return liste;
	}

	@Override
	public EleveFormateur find(Long id) {
		EleveFormateur obj = null;
		
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.find(EleveFormateur.class, id);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return obj;
	}

	@Override
	public EleveFormateur save(EleveFormateur obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			obj = em.merge(obj);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return obj;
	}

	@Override
	public void delete(EleveFormateur obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Application.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.remove(em.merge(obj));
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
