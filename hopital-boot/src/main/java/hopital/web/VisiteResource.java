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

import hopital.model.Views;
import hopital.model.Visite;

import hopital.repository.IVisiteRepository;

@RestController
@RequestMapping("/visites")
@CrossOrigin("*")
public class VisiteResource {

	@Autowired
	private IVisiteRepository repoVisite;
	

	@GetMapping("")
	@JsonView(Views.ViewVisite.class)
	public List<Visite> findAll() {
		List<Visite> filieres = repoVisite.findAll();

		return filieres;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewVisite.class)
	public Visite findById(@PathVariable Integer id) {
		Optional<Visite> optVisite = repoVisite.findById(id);

		if (optVisite.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optVisite.get();
	}
	

	@PostMapping("")
	@JsonView(Views.ViewVisite.class)
	public Visite Visite(@Valid @RequestBody Visite visite, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La visite n'a pu être créé");
		}

		visite = repoVisite.save(visite);

		return visite;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewVisite.class)
	public Visite update(@PathVariable Integer id, @RequestBody Visite visite) {
		if (id != visite.getId() || !repoVisite.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		visite = repoVisite.save(visite);

		return visite;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!repoVisite.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		repoVisite.deleteById(id);
	}
}
