package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Ordinateur;

public interface IOrdinateurRepository extends JpaRepository<Ordinateur, Long> {

}
