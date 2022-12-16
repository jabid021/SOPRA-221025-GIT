package quest.web;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import quest.dao.IDAOFiliere;
import quest.model.Filiere;
import quest.web.validator.FiliereValidator;

@Controller
@RequestMapping("/filiere")
public class FiliereController {
	
	@Autowired
	private IDAOFiliere daoFiliere;
	
	@GetMapping("") // ETAPE 1 : RECEPTION DE LA REQUETE
	public String list(Model model) {
		// ETAPE 2 : RECUPERATION DES DONNEES
		List<Filiere> filieres = daoFiliere.findAll();
		
		// ETAPE 3 : RENSEIGNER LE MODEL
		model.addAttribute("filieres", filieres);
		
		// ETAPE 4 : APPEL DE LA VIEW
		return "filiere/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("filiere", new Filiere());
		
		return "filiere/form";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Optional<Filiere> optFiliere = daoFiliere.findById(id);
		
		if(optFiliere.isPresent()) {
			model.addAttribute("filiere", optFiliere.get());
		}
		
		return "filiere/form";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam(required = false) Integer id, @RequestParam int version, @RequestParam String libelle, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate debut, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fin) {
		Filiere filiere = new Filiere(id, libelle, debut, fin);
		filiere.setVersion(version);
				
		filiere = daoFiliere.save(filiere);
				
		return "redirect:../filiere";
	}
	
	@PostMapping("/saveBis")
	public String saveBis(@ModelAttribute("filiere") @Valid Filiere filiere, BindingResult result) {
		new FiliereValidator().validate(filiere, result);
		
		if(result.hasErrors()) {
			return "filiere/form";
		}
		
		filiere = daoFiliere.save(filiere);
				
		return "redirect:../filiere";
	}


	@GetMapping("/cancel")
	public String cancel() {
		
		return "forward:/filiere";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		daoFiliere.deleteById(id);
		
		return "redirect:../filiere";
	}
}
