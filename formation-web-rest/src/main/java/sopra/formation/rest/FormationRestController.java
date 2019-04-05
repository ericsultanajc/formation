package sopra.formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Formation;
import sopra.formation.model.Personne;
import sopra.formation.model.Views.ViewFormation;
import sopra.formation.model.Views.ViewFormationWithClient;
import sopra.formation.model.Views.ViewPersonne;
import sopra.formation.repository.IFormationRepository;
import sopra.formation.repository.IPersonneRepository;

@RestController
@RequestMapping("/formation")
@CrossOrigin("*")
public class FormationRestController {

	@Autowired
	private IFormationRepository formationRepo;
	
	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@JsonView(ViewFormation.class)
	public List<Formation> list() {
		return formationRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(ViewFormationWithClient.class)
	public Formation find(@PathVariable Long id) {
		return formationRepo.findByIdWithClient(id);
	}
	
	@GetMapping("/{id}/personnes")
	@JsonView(ViewPersonne.class)
	public List<Personne> findPersonne(@PathVariable Long id) {
		return personneRepo.findByFormationId(id);
	}

	@PostMapping("")
	@JsonView(ViewFormation.class)
	public Formation create(@RequestBody Formation formation) {
		formation = formationRepo.save(formation);

		return formation;
	}

	@PutMapping("/{id}")
	@JsonView(ViewFormation.class)
	public Formation update(@RequestBody Formation formation, @PathVariable Long id) {
		formation = formationRepo.save(formation);

		return formation;
	}

	@DeleteMapping("/{id}")
	@JsonView(ViewFormation.class)
	public void remove(@PathVariable Long id) {
		formationRepo.deleteById(id);
	}

}
