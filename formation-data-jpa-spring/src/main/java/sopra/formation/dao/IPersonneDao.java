package sopra.formation.dao;

import java.util.List;

import sopra.formation.model.Eleve;
import sopra.formation.model.Formateur;
import sopra.formation.model.Formation;
import sopra.formation.model.Personne;

public interface IPersonneDao extends IDao<Personne, Long>{
	List<Eleve> findAllEleve();
	List<Formateur> findAllFormateur();
	List<Formateur> findAllFormateurByMatiere(Long matiereId);
	List<Personne> findAllByFormation(Formation formation);
	List<Eleve> findAllEleveByFormateur(Long formateurId);
}
