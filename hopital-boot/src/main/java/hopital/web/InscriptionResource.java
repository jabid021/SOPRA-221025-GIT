package hopital.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import hopital.model.Inscription;
import hopital.model.Views;
import hopital.repository.IInscriptionRepository;



public class InscriptionResource {
	
	@Autowired
	private IInscriptionRepository daoInscription;

	@GetMapping("")
	@JsonView(Views.ViewInscription.class)
	public List<Inscription> findall() {
		List<Inscription> inscriptions = daoInscription.findAll();

		return inscriptions;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewInscription.class)
	public Inscription findById(@PathVariable Integer id) {
		Optional<Inscription> optInscription = daoInscription.findById(id);

		if (optInscription.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optInscription.get();
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewInscriptionWithMedecin.class)
	public Inscription detailById(@PathVariable Integer id) {
		Optional<Inscription> optInscription = daoInscription.findById(id);

		if (optInscription.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optInscription.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewInscription.class)
	public Inscription create(@Valid @RequestBody Inscription inscription, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le inscription n'a pu être créé");
		}

		inscription = daoInscription.save(inscription);

		return inscription;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewInscription.class)
	public Inscription update(@PathVariable Integer id, @RequestBody Inscription inscription) {
		if (id != inscription.getId() || !daoInscription.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		inscription = daoInscription.save(inscription);

		return inscription;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoInscription.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoInscription.deleteById(id);
	}
	

}
