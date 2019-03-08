package sopra.formation.dao;

import java.util.List;

import sopra.formation.model.Matiere;

public interface IMatiereDao extends IDao<Matiere, Long> {
	List<Matiere> findAllByNom(String nom);
	List<Matiere> findAllByDuree(int duree);
}
