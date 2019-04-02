package sopra.formation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.model.Client;
import sopra.formation.model.ClientId;
import sopra.formation.model.StatutJuridique;
import sopra.formation.repository.IClientRepository;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientRepository clientRepo;

	@GetMapping("")
	public String defaut() {
		return "redirect:/client/list";
	}

	@GetMapping(path = { "/", "/list" })
	public String list(Model model) {
		List<Client> clients = clientRepo.findAll();

		model.addAttribute("clients", clients);

		return "client/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("client", new Client());
		model.addAttribute("statutJuridiques", StatutJuridique.values());
		model.addAttribute("mode", "add");

		return "client/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam String siret, @RequestParam String raisonSociale, Model model) {
		Optional<Client> opt = clientRepo.findById(new ClientId(siret, raisonSociale));

		if (opt.isPresent()) {
			model.addAttribute("client", opt.get());
		}

		model.addAttribute("statutJuridiques", StatutJuridique.values());
		model.addAttribute("mode", "edit");

		return "client/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam String siret, @RequestParam String raisonSociale, @RequestParam int version,
			@RequestParam StatutJuridique statutJuridique) {
		Optional<Client> opt = clientRepo.findById(new ClientId(siret, raisonSociale));

		Client client = null;
		if (opt.isPresent()) {
			client = opt.get();
		} else {
			client = new Client(siret, raisonSociale);
		}

		client.setVersion(version);
		client.setStatutJuridique(statutJuridique);

		clientRepo.save(client);

		return "redirect:/client/list";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam String siret, @RequestParam String raisonSociale) {
		clientRepo.deleteById(new ClientId(siret, raisonSociale));

		return "forward:/client/list";
	}

	@GetMapping("/cancel")
	public String cancel() {

		return "forward:/client/list";
	}

}
