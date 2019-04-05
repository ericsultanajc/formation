package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Salle;
import sopra.formation.model.SalleId;

public interface ISalleRepository extends JpaRepository<Salle, SalleId> {
	@Query("select distinct s from Salle s left join fetch s.formation where s.id = :id")
	Salle findByIdWithFormation(@Param("id") SalleId id);
}
