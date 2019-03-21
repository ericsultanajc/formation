package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Client;
import sopra.formation.model.ClientId;

public interface IClientRepository extends JpaRepository<Client, ClientId> {

}
