package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Eleve;
import sopra.formation.model.Formateur;
import sopra.formation.model.Formation;
import sopra.formation.model.Personne;

public interface IPersonneRepository extends JpaRepository<Personne, Long> {

	@Query("select e from Eleve e")
	List<Eleve> findAllEleve();

	@Query("select f from Formateur f")
	List<Formateur> findAllFormateur();

	@Query("select f from Formateur f join f.matieres m where m.id = :idMatiere")
	List<Formateur> findAllFormateurByMatiere(@Param("idMatiere") Long matiereId);

	List<Personne> findByFormation(Formation formation);

	@Query("select ef.eleve from EleveFormateur ef where ef.formateur.id = :formateurId")
	List<Eleve> findAllEleveByFormateur(@Param("formateurId") Long formateurId);
}
