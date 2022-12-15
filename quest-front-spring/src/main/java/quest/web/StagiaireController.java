package quest.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

@Controller
public class StagiaireController {
	
	@Autowired
	private IDAOStagiaire daoStagiaire;
	
	@GetMapping("/stagiaire") // ETAPE 1 : RECEPTION DE LA REQUETE
	public String list(Model model) {
		// ETAPE 2 : RECUPERATION DES DONNEES
		List<Stagiaire> stagiaires = daoStagiaire.findAll();
		
		// ETAPE 3 : RENSEIGNER LE MODEL
		model.addAttribute("mesStagiaires", stagiaires);
		
		// ETAPE 4 : APPEL DE LA VIEW
		return "stagiaire/list";
	}
	
	@GetMapping("/stagiaire/add")
	public String add(Model model) {
		model.addAttribute("stagiaire", new Stagiaire());
		
		return "stagiaire/form";
	}
	
	@GetMapping("/stagiaire/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Optional<Stagiaire> optStagiaire = daoStagiaire.findById(id);
		
		if(optStagiaire.isPresent()) {
			model.addAttribute("stagiaire", optStagiaire.get());
		}
		
		return "stagiaire/form";
	}
	
	@PostMapping("/stagiaire/save")
	public String save(@RequestParam(required = false) Integer id, @RequestParam int version, @RequestParam String nom, @RequestParam String prenom, @RequestParam String email) {
		Stagiaire stagiaire = new Stagiaire(id, nom, prenom, email, null);
		stagiaire.setVersion(version);
		
		stagiaire = daoStagiaire.save(stagiaire);
				
		return "redirect:../stagiaire";
	}

	@GetMapping("/stagiaire/cancel")
	public String cancel() {
		
		return "forward:/stagiaire";
	}
	
	@GetMapping("/stagiaire/delete")
	public String delete(@RequestParam Integer id) {
		daoStagiaire.deleteById(id);
		
		return "redirect:../stagiaire";
	}
}
