package test.sopra.formation;

import sopra.formation.model.Adresse;
import sopra.formation.model.Eleve;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;

public class TestFormation {

	public static void main(String[] args) {
		Eleve jordi = new Eleve("SARPOULET", "Jordi", 27);

		Adresse adresseJordi = new Adresse("1 rue de la Paix", "75008", "Paris");

		jordi.setAdr(adresseJordi);

		Eleve louis = new Eleve("FORCADE", "Louis", 27);

		Adresse adresselouis = new Adresse("1 rue de versailles", "78000", "Versailles");

		louis.setAdr(adresselouis);

		Formateur eric = new Formateur("SULTAN", "Eric", 20);
		
		eric.setAdr(adresselouis);

//		jordi.setFormateur(eric);
//
//		eric.getEleves().add(jordi);
//
//		eric.addEleve(louis);

		Matiere algo = new Matiere("ALGO", 3);

		algo.addFormateur(eric);

		eric.addMatiere(algo);

		Matiere uml = new Matiere("UML", 1);

		uml.addFormateur(eric);

		eric.addMatiere(uml);
		
		Matiere uml2 = new Matiere("UML", 1);

		uml2.addFormateur(eric);

		eric.addMatiere(uml2);
		
		System.out.println(uml.equals(uml2));
		
		System.out.println(uml);
	}

}
