package quest.web;

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

import quest.dao.IDAOFiliere;
import quest.dao.IDAOStagiaire;
import quest.model.Filiere;
import quest.model.Stagiaire;
import quest.model.Views;

@RestController
@RequestMapping("/filieres")
@CrossOrigin("*")
public class FiliereResource {

	@Autowired
	private IDAOFiliere daoFiliere;
	
	@Autowired
	private IDAOStagiaire daoStagiaire;

	@GetMapping("")
	@JsonView(Views.ViewFiliere.class)
	public List<Filiere> findAll() {
		List<Filiere> filieres = daoFiliere.findAll();

		return filieres;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFiliere.class)
	public Filiere findById(@PathVariable Integer id) {
		Optional<Filiere> optFiliere = daoFiliere.findById(id);

		if (optFiliere.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optFiliere.get();
	}
	
	@GetMapping("/{id}/with-stagiaires")
	@JsonView(Views.ViewFiliereWithStagiaires.class)
	public Filiere findByIdWithStagiaires(@PathVariable Integer id) {
		Optional<Filiere> optFiliere = daoFiliere.findByIdWithStagiaires(id);

		if (optFiliere.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optFiliere.get();
	}
	
	@GetMapping("/{id}/with-matieres")
	@JsonView(Views.ViewFiliereWithMatieres.class)
	public Filiere findByIdWithMatieres(@PathVariable Integer id) {
		Optional<Filiere> optFiliere = daoFiliere.findByIdWithMatieres(id);

		if (optFiliere.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optFiliere.get();
	}
	
	@GetMapping("/{id}/with-all")
	@JsonView(Views.ViewFiliereWithAll.class)
	public Filiere findByIdWithAll(@PathVariable Integer id) {
		Optional<Filiere> optFiliere = daoFiliere.findByIdWithMatieres(id);		

		if (optFiliere.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		List<Stagiaire> stagiaires = daoStagiaire.findAllByFiliere(id);
		
		Filiere filiere = optFiliere.get();
		filiere.setStagiaires(stagiaires);

		return filiere;
	}

	@PostMapping("")
	@JsonView(Views.ViewFiliere.class)
	public Filiere create(@Valid @RequestBody Filiere filiere, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le filiere n'a pu être créé");
		}

		filiere = daoFiliere.save(filiere);

		return filiere;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFiliere.class)
	public Filiere update(@PathVariable Integer id, @RequestBody Filiere filiere) {
		if (id != filiere.getId() || !daoFiliere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		filiere = daoFiliere.save(filiere);

		return filiere;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoFiliere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoFiliere.deleteById(id);
	}
}
