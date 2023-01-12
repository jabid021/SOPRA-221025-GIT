package hopital.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Secretaire;
import hopital.model.Views;
import hopital.repository.ICompteRepository;

@RestController
@RequestMapping("/comptes")
@CrossOrigin("*")
public class CompteResource {
	
	@Autowired
	private ICompteRepository daoCompte;
	
//****************************************************** POUR TOUT LES COMTPES ****************************************************************//
	@GetMapping("")
	@JsonView(Views.ViewCompte.class)
	public List<Compte> findAll() {
		List<Compte> comptes = daoCompte.findAll();

		return comptes;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompte.deleteById(id);
	}

	//****************************************************** POUR TOUT LES MEDECINS ****************************************************************//

	@GetMapping("/medecins")
	@JsonView(Views.ViewCompteMed.class)
	public List<Medecin> findAllMedecins() {
		List<Medecin> comptesMed = daoCompte.findAllMedecin();

		return comptesMed;
	}
	
	//Compte Medecin by ID
	@GetMapping("/medecins/{id}")
	@JsonView(Views.ViewCompteMed.class)
	public Medecin findByIdMed(@PathVariable Integer id) {
		Optional<Medecin> optMedecin = daoCompte.findMedecinById(id);

		if (optMedecin.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optMedecin.get();
	}

	@PostMapping("/addMedecin")
	@JsonView(Views.ViewCompteMed.class)
	public Medecin createMed(@Valid @RequestBody Medecin medecin, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le stagiaire n'a pu être créé");
		}

		medecin = daoCompte.save(medecin);

		return medecin;
	}
	@PutMapping("medecin/{id}")
	@JsonView(Views.ViewCompteMed.class)
	public Medecin updateMed(@PathVariable Integer id, @RequestBody Medecin medecin) {
		if (id != medecin.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		medecin = daoCompte.save(medecin);

		return medecin;
	}
	//****************************************************** POUR TOUTES LES SECRETAIRES ****************************************************************//
	//Liste de toutes les secretaires
	@GetMapping("/secretaires")
	@JsonView(Views.ViewCompteMed.class)
	public List<Secretaire> findAllSecretaire() {
		List<Secretaire> comptesSec = daoCompte.findAllSecretaire();

		return comptesSec;
	}
	
	//Compte Secretaire  by ID
	@GetMapping("/secretaires/{id}")
	@JsonView(Views.ViewCompte.class)
	public Secretaire findByIdSec(@PathVariable Integer id) {
		Optional<Secretaire> optSecretaire = daoCompte.findSecretaireById(id);

		if (optSecretaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optSecretaire.get();
	}

	@PostMapping("/addSecretaire")
	@JsonView(Views.ViewCompte.class)
	public Secretaire createSec(@Valid @RequestBody Secretaire secretaire, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La secrétaire n'a pu être créé");
		}

		secretaire = daoCompte.save(secretaire);

		return secretaire;
	}
	@PutMapping("secretaires/{id}")
	@JsonView(Views.ViewCompteMed.class)
	public Secretaire update(@PathVariable Integer id, @RequestBody Secretaire secretaire) {
		if (id != secretaire.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		secretaire = daoCompte.save(secretaire);

		return secretaire;
	}
	
}
