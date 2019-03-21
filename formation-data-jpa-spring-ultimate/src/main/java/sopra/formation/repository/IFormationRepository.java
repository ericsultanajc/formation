package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Formation;

public interface IFormationRepository extends JpaRepository<Formation, Long> {
}
