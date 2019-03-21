package test.sopra.formation;

import java.util.Date;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.model.Adresse;
import sopra.formation.model.Client;
import sopra.formation.model.Eleve;
import sopra.formation.model.EleveFormateur;
import sopra.formation.model.Formateur;
import sopra.formation.model.Formation;
import sopra.formation.model.Matiere;
import sopra.formation.model.Ordinateur;
import sopra.formation.model.Personne;
import sopra.formation.model.Salle;
import sopra.formation.model.StatutJuridique;
import sopra.formation.repository.IClientRepository;
import sopra.formation.repository.IEleveFormateurRepository;
import sopra.formation.repository.IFormationRepository;
import sopra.formation.repository.IMatiereRepository;
import sopra.formation.repository.IOrdinateurRepository;
import sopra.formation.repository.IPersonneRepository;
import sopra.formation.repository.ISalleRepository;

public class TestFormation {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		IClientRepository clientRepo = context.getBean(IClientRepository.class);
		IEleveFormateurRepository eleveFormateurRepo = context.getBean(IEleveFormateurRepository.class);
		IFormationRepository formationRepo = context.getBean(IFormationRepository.class);
		IMatiereRepository matiereRepo = context.getBean(IMatiereRepository.class);
		IOrdinateurRepository ordinateurRepo = context.getBean(IOrdinateurRepository.class);
		IPersonneRepository personneRepo = context.getBean(IPersonneRepository.class);
		ISalleRepository salleRepo = context.getBean(ISalleRepository.class);

		Client sopraSteria = new Client("32682006500083", "SOPRA STERIA GROUP", StatutJuridique.SA);

		sopraSteria = clientRepo.save(sopraSteria);

		Salle wim = new Salle("San Francisco", "Merignac", 12);

		wim = salleRepo.save(wim);

		Formation lesMeilleurs = new Formation("CP JAVA", "Les Meilleurs", new Date());
		lesMeilleurs.setClient(sopraSteria);
		lesMeilleurs.setSalle(wim);
		lesMeilleurs = formationRepo.save(lesMeilleurs);

		Matiere algo = new Matiere("ALGO", 3);

		algo = matiereRepo.save(algo);

		Matiere jpa = new Matiere("JPA", 5);

		jpa = matiereRepo.save(jpa);

		Formateur eric = new Formateur("SULTAN", "Eric", 20);
		eric.setAdr(new Adresse("4 rue Marguerite Elie Guadet", "33160", "Saint-Medard-en-Jalles"));
		eric.setFormation(lesMeilleurs);
		eric.addMatiere(algo);
		eric.addMatiere(jpa);

		eric = (Formateur) personneRepo.save(eric);

		Ordinateur ordi387 = new Ordinateur("AJC-387", "ASUS", 8, true);
		ordi387 = ordinateurRepo.save(ordi387);

		Eleve jordi = new Eleve("SARPOULET", "Jordi", 27);
		jordi.setAdr(new Adresse("1 rue Sainte Catherine", "33000", "Bordeaux"));
		jordi.setOrdinateur(ordi387);
		jordi.setFormation(lesMeilleurs);

		jordi = (Eleve) personneRepo.save(jordi);

		EleveFormateur jordiEric = new EleveFormateur(jordi, eric, 7);

		eleveFormateurRepo.save(jordiEric);

		Ordinateur ordi405 = new Ordinateur("AJC-405", "ASUS", 8, true);
		ordi405 = ordinateurRepo.save(ordi405);

		Eleve geraldine = new Eleve("CAUMES", "Géraldine", 27);
		geraldine.setAdr(new Adresse("1 rue Sainte Catherine", "33000", "Bordeaux"));
		geraldine.setOrdinateur(ordi405);
		geraldine.setFormation(lesMeilleurs);

		geraldine = (Eleve) personneRepo.save(geraldine);

		EleveFormateur geraldineEric = new EleveFormateur(geraldine, eric, 17);

		eleveFormateurRepo.save(geraldineEric);

//		Matiere jpaFind = matiereRepo.find(jpa.getId());
//		
//		for(Formateur formateur : jpaFind.getFormateurs()) {
//			System.out.println(formateur.getNom());
//		}

		Optional<Personne> geraldineFind = personneRepo.findById(geraldine.getId());

//		System.out.println(geraldineFind.getOrdinateur().getCode());

		context.close();
	}

}
