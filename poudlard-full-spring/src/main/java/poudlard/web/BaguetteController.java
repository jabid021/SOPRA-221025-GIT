package poudlard.web;

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

import poudlard.model.Baguette;
import poudlard.model.Sorcier;
import poudlard.repository.IBaguetteRepository;
import poudlard.repository.ISorcierRepository;
import poudlard.web.validator.BaguetteValidator;


@Controller
@RequestMapping("/baguette")
public class BaguetteController {
	
	@Autowired
	private IBaguetteRepository iBaguette;

	@Autowired
	private ISorcierRepository iSorcier;

	@GetMapping("") // ETAPE 1 : RECEPTION DE LA REQUETE
	public String list(Model model) {
		// ETAPE 2 : RECUPERATION DES DONNEES
		List<Baguette> baguettes = iBaguette.findAll();

		// ETAPE 3 : RENSEIGNER LE MODEL
		model.addAttribute("mesBaguettes", baguettes);

		// ETAPE 4 : APPEL DE LA VIEW
		return "baguette/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("baguette", new Baguette());
		model.addAttribute("sorcier", iSorcier.findAll());

		return "baguette/form";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		Optional<Baguette> optBaguette = iBaguette.findById(id);

		if (optBaguette.isPresent()) {
			model.addAttribute("baguette", optBaguette.get());
		}

		model.addAttribute("sorcier", iSorcier.findAll());

		return "baguette/form";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam(required = false) Integer id, @RequestParam int version, @RequestParam String nom,
			@RequestParam(required = false) Integer idSorcier) {
		
		Baguette baguette = new Baguette(id, nom, null);
		baguette.setVersion(version);

		if(idSorcier != null) {
			Optional<Sorcier> optSorcier = iSorcier.findById(idSorcier);
			
			if(optSorcier.isPresent()) {
				baguette.setSorcier(optSorcier.get());
			}
		}
		
		
		baguette = iBaguette.save(baguette);

		return "redirect:../baguette";
	}
	
	@PostMapping("/saveBis")
	public String saveBis(@ModelAttribute("baguette") @Valid Baguette baguette, BindingResult result,
			@RequestParam(required = false) Integer idSorcier, Model model) {
		new BaguetteValidator().validate(baguette, result);
		
		if(result.hasErrors()) {
			model.addAttribute("baguette", iBaguette.findAll());
			
			return "baguette/form";
		}
		
		if(idSorcier != null) {
			Optional<Sorcier> optSorcier = iSorcier.findById(idSorcier);
			
			if(optSorcier.isPresent()) {
				baguette.setSorcier(optSorcier.get());
			}
		}
		
		baguette = iBaguette.save(baguette);
		
	
		return "redirect:../baguette";
	}
	
	@GetMapping("/cancel")
	public String cancel() {

		return "forward:/baguette";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		iBaguette.deleteById(id);

		return "redirect:../baguette";
	}

}
