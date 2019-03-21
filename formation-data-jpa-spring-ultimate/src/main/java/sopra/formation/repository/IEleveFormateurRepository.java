package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.EleveFormateur;

public interface IEleveFormateurRepository extends JpaRepository<EleveFormateur, Long> {

}
