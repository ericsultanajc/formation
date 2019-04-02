package sopra.formation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.model.Matiere;
import sopra.formation.repository.IMatiereRepository;

@Controller
@RequestMapping("/matiere")
public class MatiereController {

	@Autowired
	private IMatiereRepository matiereRepo;

	@GetMapping("")
	public String defaut() {
		return "redirect:/matiere/list";
	}

	@GetMapping(path = { "/", "/list" })
	public String list(Model model) {
		List<Matiere> matieres = matiereRepo.findAll();

		model.addAttribute("mesMatieres", matieres);

		return "matiere/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("maMatiere", new Matiere());

		return "matiere/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Matiere> opt = matiereRepo.findById(id);

		if (opt.isPresent()) {
			model.addAttribute("maMatiere", opt.get());
		}

		return "matiere/form";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("maMatiere") Matiere matiere, BindingResult result) {
		if(result.hasErrors()) {
			return "matiere/form";
		}
		
		matiereRepo.save(matiere);

		return "redirect:/matiere/list";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("id") Long id) {
		matiereRepo.deleteById(id);

		return "forward:/matiere/list";
	}

	@GetMapping("/cancel")
	public String cancel() {

		return "forward:/matiere/list";
	}

}
