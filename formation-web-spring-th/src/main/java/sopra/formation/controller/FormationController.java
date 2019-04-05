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

import sopra.formation.model.Dispositif;
import sopra.formation.model.Formation;
import sopra.formation.repository.IFormationRepository;

@Controller
@RequestMapping("/formation")
public class FormationController {

	@Autowired
	private IFormationRepository formationRepo;

	@GetMapping("")
	public String defaut() {
		return "redirect:/formation/list";
	}

	@GetMapping(path = { "/", "/list" })
	public String list(Model model) {
		List<Formation> formations = formationRepo.findAll();

		model.addAttribute("formations", formations);

		return "formation/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("formation", new Formation());
		model.addAttribute("dispositifs", Dispositif.values());

		return "formation/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Formation> opt = formationRepo.findById(id);

		if (opt.isPresent()) {
			model.addAttribute("formation", opt.get());
		}
		
		model.addAttribute("dispositifs", Dispositif.values());

		return "formation/form";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("formation") Formation formation, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dispositifs", Dispositif.values());
			return "formation/form";
		}

		formationRepo.save(formation);

		return "redirect:/formation/list";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam("id") Long id) {
		formationRepo.deleteById(id);

		return "forward:/formation/list";
	}

	@GetMapping("/cancel")
	public String cancel() {

		return "forward:/formation/list";
	}

}
