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

import sopra.formation.model.Salle;
import sopra.formation.model.SalleId;
import sopra.formation.model.Views.ViewSalle;
import sopra.formation.model.Views.ViewSalleWithFormation;
import sopra.formation.repository.ISalleRepository;

@RestController
@RequestMapping("/salle")
@CrossOrigin("*")
public class SalleRestController {

	@Autowired
	private ISalleRepository salleRepo;

	@GetMapping("")
	@JsonView(ViewSalle.class)
	public List<Salle> list() {
		return salleRepo.findAll();
	}

	@GetMapping("/{nom}:{lieu}")
	@JsonView(ViewSalle.class)
	public Salle find(@PathVariable String nom, @PathVariable String lieu) {
		return salleRepo.findById(new SalleId(nom, lieu)).get();
	}
	
	@GetMapping("/{nom}:{lieu}/detail")
	@JsonView(ViewSalleWithFormation.class)
	public Salle findDetail(@PathVariable String nom, @PathVariable String lieu) {
		return salleRepo.findByIdWithFormation(new SalleId(nom, lieu));
	}

	@PostMapping("")
	@JsonView(ViewSalle.class)
	public Salle create(@RequestBody Salle salle) {
		salle = salleRepo.save(salle);

		return salle;
	}

	@PutMapping("/{nom}:{lieu}")
	@JsonView(ViewSalle.class)
	public Salle update(@RequestBody Salle salle, @PathVariable String nom, @PathVariable String lieu) {
		salle = salleRepo.save(salle);

		return salle;
	}

	@DeleteMapping("/{nom}:{lieu}")
	@JsonView(ViewSalle.class)
	public void remove(@PathVariable String nom, @PathVariable String lieu) {
		salleRepo.deleteById(new SalleId(nom, lieu));
	}

}
