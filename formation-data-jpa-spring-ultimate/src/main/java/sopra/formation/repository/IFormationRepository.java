package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Formation;

public interface IFormationRepository extends JpaRepository<Formation, Long> {
	@Query("select distinct f from Formation f left join fetch f.client where f.id = :id")
	Formation findByIdWithClient(@Param("id") Long id);
}
