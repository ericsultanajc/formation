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

import sopra.formation.model.Matiere;
import sopra.formation.repository.IMatiereRepository;

@RestController
@RequestMapping("/matiere")
@CrossOrigin("*") // autoriser l'accès depuis n'importe quelle adresse
public class MatiereRestController {

	@Autowired
	private IMatiereRepository matiereRepo;

	@GetMapping("")
	public List<Matiere> list() {
		return matiereRepo.findAll();
	}

	@GetMapping("/{id}")
	public Matiere find(@PathVariable Long id) {
		return matiereRepo.findById(id).get();
	}

	@PostMapping("")
	public Matiere create(@RequestBody Matiere matiere) {
		matiere = matiereRepo.save(matiere);

		return matiere;
	}
	
	@PutMapping("/{id}")
	public Matiere update(@RequestBody Matiere matiere, @PathVariable Long id) {
		matiere = matiereRepo.save(matiere);

		return matiere;
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable Long id) {
		matiereRepo.deleteById(id);
	}

}
