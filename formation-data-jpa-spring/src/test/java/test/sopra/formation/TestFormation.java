package test.sopra.formation;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.dao.IClientDao;
import sopra.formation.dao.IEleveFormateurDao;
import sopra.formation.dao.IFormationDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IOrdinateurDao;
import sopra.formation.dao.IPersonneDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Client;
import sopra.formation.model.Eleve;
import sopra.formation.model.EleveFormateur;
import sopra.formation.model.Formateur;
import sopra.formation.model.Formation;
import sopra.formation.model.Matiere;
import sopra.formation.model.Ordinateur;
import sopra.formation.model.Salle;
import sopra.formation.model.StatutJuridique;

public class TestFormation {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		IClientDao clientDao = context.getBean(IClientDao.class);
		IEleveFormateurDao eleveFormateurDao = context.getBean(IEleveFormateurDao.class);
		IFormationDao formationDao = context.getBean(IFormationDao.class);
		IMatiereDao matiereDao = context.getBean(IMatiereDao.class);
		IOrdinateurDao ordinateurDao = context.getBean(IOrdinateurDao.class);
		IPersonneDao personneDao = context.getBean(IPersonneDao.class);
		ISalleDao salleDao = context.getBean(ISalleDao.class);

		Client sopraSteria = new Client("32682006500083", "SOPRA STERIA GROUP", StatutJuridique.SA);

		sopraSteria = clientDao.save(sopraSteria);

		Salle wim = new Salle("San Francisco", "Merignac", 12);

		wim = salleDao.save(wim);

		Formation lesMeilleurs = new Formation("CP JAVA", "Les Meilleurs", new Date());
		lesMeilleurs.setClient(sopraSteria);
		lesMeilleurs.setSalle(wim);
		lesMeilleurs = formationDao.save(lesMeilleurs);

		Matiere algo = new Matiere("ALGO", 3);

		algo = matiereDao.save(algo);

		Matiere jpa = new Matiere("JPA", 5);

		jpa = matiereDao.save(jpa);

		Formateur eric = new Formateur("SULTAN", "Eric", 20);
		eric.setAdr(new Adresse("4 rue Marguerite Elie Guadet", "33160", "Saint-Medard-en-Jalles"));
		eric.setFormation(lesMeilleurs);
		eric.addMatiere(algo);
		eric.addMatiere(jpa);

		eric = (Formateur) personneDao.save(eric);

		Ordinateur ordi387 = new Ordinateur("AJC-387", "ASUS", 8, true);
		ordi387 = ordinateurDao.save(ordi387);

		Eleve jordi = new Eleve("SARPOULET", "Jordi", 27);
		jordi.setAdr(new Adresse("1 rue Sainte Catherine", "33000", "Bordeaux"));
		jordi.setOrdinateur(ordi387);
		jordi.setFormation(lesMeilleurs);

		jordi = (Eleve) personneDao.save(jordi);

		EleveFormateur jordiEric = new EleveFormateur(jordi, eric, 7);

		eleveFormateurDao.save(jordiEric);

		Ordinateur ordi405 = new Ordinateur("AJC-405", "ASUS", 8, true);
		ordi405 = ordinateurDao.save(ordi405);

		Eleve geraldine = new Eleve("CAUMES", "Géraldine", 27);
		geraldine.setAdr(new Adresse("1 rue Sainte Catherine", "33000", "Bordeaux"));
		geraldine.setOrdinateur(ordi405);
		geraldine.setFormation(lesMeilleurs);

		geraldine = (Eleve) personneDao.save(geraldine);

		EleveFormateur geraldineEric = new EleveFormateur(geraldine, eric, 17);

		eleveFormateurDao.save(geraldineEric);
		
		
		
//		Matiere jpaFind = matiereDao.find(jpa.getId());
//		
//		for(Formateur formateur : jpaFind.getFormateurs()) {
//			System.out.println(formateur.getNom());
//		}
		
		Eleve geraldineFind = (Eleve) personneDao.find(geraldine.getId());
		
//		System.out.println(geraldineFind.getOrdinateur().getCode());
	}

}
