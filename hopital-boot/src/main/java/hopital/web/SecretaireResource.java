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

import hopital.model.Secretaire;
import hopital.model.Views;
import hopital.repository.ICompteRepository;

@RestController
@RequestMapping("/medecins")
@CrossOrigin("*")
public class SecretaireResource {

	@Autowired
	private ICompteRepository daoCompte;

	@GetMapping("")
	@JsonView(Views.ViewSecretaire.class)
	public List<Secretaire> findAll() {
		List<Secretaire> medecins = daoCompte.findAllSecretaire();

		return medecins;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSecretaire.class)
	public Secretaire findById(@PathVariable Integer id) {
		Optional<Secretaire> optSecretaire = daoCompte.findSecretaireById(id);

		if (optSecretaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optSecretaire.get();
	}
	

	@PostMapping("")
	@JsonView(Views.ViewSecretaire.class)
	public Secretaire create(@Valid @RequestBody Secretaire filiere, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le filiere n'a pu être créé");
		}

		filiere = daoCompte.save(filiere);

		return filiere;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSecretaire.class)
	public Secretaire update(@PathVariable Integer id, @RequestBody Secretaire filiere) {
		if (id != filiere.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		filiere = daoCompte.save(filiere);

		return filiere;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompte.deleteById(id);
	}
}
