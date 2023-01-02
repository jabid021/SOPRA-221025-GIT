package quest.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

@RestController
@RequestMapping("/stagiaires")
@CrossOrigin("*")
public class StagiaireResource {

	@Autowired
	private IDAOStagiaire daoStagiaire;

	@GetMapping("")
	public List<Stagiaire> findall() {
		List<Stagiaire> stagiaires = daoStagiaire.findAll();

		return stagiaires;
	}

	@GetMapping("/{id}")
	public Stagiaire findById(@PathVariable Integer id) {
		Optional<Stagiaire> optStagiaire = daoStagiaire.findById(id);

		if (optStagiaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optStagiaire.get();
	}

	@PostMapping("")
	public Stagiaire create(@Valid @RequestBody Stagiaire stagiaire, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le stagiaire n'a pu être créé");
		}

		stagiaire = daoStagiaire.save(stagiaire);

		return stagiaire;
	}

	@PutMapping("/{id}")
	public Stagiaire update(@PathVariable Integer id, @RequestBody Stagiaire stagiaire) {
		if (id != stagiaire.getId() || !daoStagiaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		stagiaire = daoStagiaire.save(stagiaire);

		return stagiaire;
	}
}
