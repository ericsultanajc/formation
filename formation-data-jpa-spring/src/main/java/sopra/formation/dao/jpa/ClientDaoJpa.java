package sopra.formation.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.dao.IClientDao;
import sopra.formation.model.Client;
import sopra.formation.model.ClientId;

@Repository // @Component spécialisé pour les DAO (ou Repository)
@Transactional
public class ClientDaoJpa implements IClientDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		TypedQuery<Client> query = em.createQuery("from Client", Client.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Client find(ClientId id) {
		return em.find(Client.class, id);
	}

	@Override
	public Client save(Client obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Client obj) {
		em.remove(em.merge(obj));
	}

}
