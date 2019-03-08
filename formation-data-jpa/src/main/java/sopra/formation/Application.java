package sopra.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.dao.IClientDao;
import sopra.formation.dao.IEleveFormateurDao;
import sopra.formation.dao.IFormationDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IOrdinateurDao;
import sopra.formation.dao.IPersonneDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.jpa.ClientDaoJpa;
import sopra.formation.dao.jpa.EleveFormateurDaoJpa;
import sopra.formation.dao.jpa.FormationDaoJpa;
import sopra.formation.dao.jpa.MatiereDaoJpa;
import sopra.formation.dao.jpa.OrdinateurDaoJpa;
import sopra.formation.dao.jpa.PersonneDaoJpa;
import sopra.formation.dao.jpa.SalleDaoJpa;

public class Application {

	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("maFormation");

	private final IClientDao clientDao = new ClientDaoJpa();
	private final IEleveFormateurDao eleveFormateurDao = new EleveFormateurDaoJpa();
	private final IFormationDao formationDao = new FormationDaoJpa();
	private final IMatiereDao matiereDao = new MatiereDaoJpa();
	private final IOrdinateurDao ordinateurDao = new OrdinateurDaoJpa();
	private final IPersonneDao personneDao = new PersonneDaoJpa();
	private final ISalleDao salleDao = new SalleDaoJpa();

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IClientDao getClientDao() {
		return clientDao;
	}

	public IEleveFormateurDao getEleveFormateurDao() {
		return eleveFormateurDao;
	}

	public IFormationDao getFormationDao() {
		return formationDao;
	}

	public IMatiereDao getMatiereDao() {
		return matiereDao;
	}

	public IOrdinateurDao getOrdinateurDao() {
		return ordinateurDao;
	}

	public IPersonneDao getPersonneDao() {
		return personneDao;
	}

	public ISalleDao getSalleDao() {
		return salleDao;
	}

}
