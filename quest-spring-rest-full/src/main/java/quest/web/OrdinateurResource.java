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

import quest.dao.IDAOOrdinateur;
import quest.model.Ordinateur;
import quest.model.Views;

@RestController
@RequestMapping("/ordinateurs")
@CrossOrigin("*")
public class OrdinateurResource {

	@Autowired
	private IDAOOrdinateur daoOrdinateur;

	@GetMapping("")
	@JsonView(Views.ViewOrdinateur.class)
	public List<Ordinateur> findall() {
		List<Ordinateur> ordinateurs = daoOrdinateur.findAll();

		return ordinateurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewOrdinateur.class)
	public Ordinateur findById(@PathVariable Integer id) {
		Optional<Ordinateur> optOrdinateur = daoOrdinateur.findById(id);

		if (optOrdinateur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optOrdinateur.get();
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewOrdinateurWithStagiaire.class)
	public Ordinateur detailById(@PathVariable Integer id) {
		Optional<Ordinateur> optOrdinateur = daoOrdinateur.findById(id);

		if (optOrdinateur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optOrdinateur.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewOrdinateur.class)
	public Ordinateur create(@Valid @RequestBody Ordinateur ordinateur, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le ordinateur n'a pu être créé");
		}

		ordinateur = daoOrdinateur.save(ordinateur);

		return ordinateur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewOrdinateur.class)
	public Ordinateur update(@PathVariable Integer id, @RequestBody Ordinateur ordinateur) {
		if (id != ordinateur.getId() || !daoOrdinateur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		ordinateur = daoOrdinateur.save(ordinateur);

		return ordinateur;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoOrdinateur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoOrdinateur.deleteById(id);
	}
}
