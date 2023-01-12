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
import hopital.model.Views;
import hopital.repository.ICompteRepository;



@RestController
@RequestMapping("/inscriptions")
@CrossOrigin("*")
public class InscriptionResource {
	
	@Autowired
	private ICompteRepository daoCompte;

	@GetMapping("")
	@JsonView(Views.ViewInscription.class)
	public List<Compte> findall() {
		List<Compte> inscriptions = daoCompte.findAll();

		return inscriptions;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewInscription.class)
	public Compte findById(@PathVariable Integer id) {
		Optional<Compte> optCompte = daoCompte.findById(id);

		if (optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompte.get();
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewInscriptionWithMedecin.class)
	public Compte detailById(@PathVariable Integer id) {
		Optional<Compte> optCompte = daoCompte.findById(id);

		if (optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompte.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewInscription.class)
	public Compte create(@Valid @RequestBody Compte inscription, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le inscription n'a pu être créé");
		}

		inscription = daoCompte.save(inscription);

		return inscription;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewInscription.class)
	public Compte update(@PathVariable Integer id, @RequestBody Compte inscription) {
		if (id != inscription.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		inscription = daoCompte.save(inscription);

		return inscription;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompte.deleteById(id);
	}
	

}
