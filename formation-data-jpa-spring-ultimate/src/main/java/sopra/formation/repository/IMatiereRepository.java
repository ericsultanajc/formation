package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Matiere;

public interface IMatiereRepository extends JpaRepository<Matiere, Long> {
	List<Matiere> findByNom(String nom);

	List<Matiere> findByDuree(int duree);

	@Query("select m from Matiere m join m.formateurs f where f.nom = :monNom")
	List<Matiere> findAllByFormateur(@Param("monNom") String nom);
}
