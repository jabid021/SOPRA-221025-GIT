package quest.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOStagiaire;
import quest.model.Filiere;
import quest.model.Stagiaire;

@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {

	@Autowired
	private IDAOStagiaire daoStagiaire;

	@Autowired
	private IDAOFiliere daoFiliere;

	@GetMapping("") // ETAPE 1 : RECEPTION DE LA REQUETE
	public String list(Model model) {
		// ETAPE 2 : RECUPERATION DES DONNEES
		List<Stagiaire> stagiaires = daoStagiaire.findAll();

		// ETAPE 3 : RENSEIGNER LE MODEL
		model.addAttribute("mesStagiaires", stagiaires);

		// ETAPE 4 : APPEL DE LA VIEW
		return "stagiaire/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("stagiaire", new Stagiaire());
		model.addAttribute("filieres", daoFiliere.findAll());

		return "stagiaire/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Optional<Stagiaire> optStagiaire = daoStagiaire.findById(id);

		if (optStagiaire.isPresent()) {
			model.addAttribute("stagiaire", optStagiaire.get());
		}

		model.addAttribute("filieres", daoFiliere.findAll());

		return "stagiaire/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam(required = false) Integer id, @RequestParam int version, @RequestParam String nom,
			@RequestParam String prenom, @RequestParam String email,
			@RequestParam(required = false) Integer idFiliere) {
		
		Stagiaire stagiaire = new Stagiaire(id, nom, prenom, email, null);
		stagiaire.setVersion(version);

//		PROPRE MAIS PLUS COUTEUX
//		if(idFiliere != null) {
//			Optional<Filiere> optFiliere = daoFiliere.findById(idFiliere);
//			
//			if(optFiliere.isPresent()) {
//				stagiaire.setFiliere(optFiliere.get());
//			}
//		}
		
//		MOINS PROPRE MAIS MOINS COUTEUX
		if(idFiliere != null) {
			Filiere filiere = new Filiere();
			filiere.setId(idFiliere);
			stagiaire.setFiliere(filiere);
		}
		
		
		stagiaire = daoStagiaire.save(stagiaire);

		return "redirect:../stagiaire";
	}

	@GetMapping("/cancel")
	public String cancel() {

		return "forward:/stagiaire";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		daoStagiaire.deleteById(id);

		return "redirect:../stagiaire";
	}
}
