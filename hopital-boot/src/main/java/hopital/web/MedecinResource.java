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

import hopital.model.Medecin;
import hopital.model.Views;
import hopital.repository.ICompteRepository;

@RestController
@RequestMapping("/medecins")
@CrossOrigin("*")
public class MedecinResource {

	@Autowired
	private ICompteRepository daoCompte;

	@GetMapping("")
	@JsonView(Views.ViewMedecin.class)
	public List<Medecin> findAll() {
		List<Medecin> medecins = daoCompte.findAllMedecin();

		return medecins;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewMedecin.class)
	public Medecin findById(@PathVariable Integer id) {
		Optional<Medecin> optMedecin = daoCompte.findMedecinById(id);

		if (optMedecin.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optMedecin.get();
	}
	
	@GetMapping("/{id}/with-visites")
	@JsonView(Views.ViewMedecinDetail.class)
	public Medecin findByIdWithVisites(@PathVariable Integer id) {
		Optional<Medecin> optMedecin = daoCompte.findMedecinByIdWithVisites(id);
		if (optMedecin.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optMedecin.get();
	}
	

	@PostMapping("")
	@JsonView(Views.ViewMedecin.class)
	public Medecin create(@Valid @RequestBody Medecin medecin, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le medecin n'a pu être créé");
		}

		medecin = daoCompte.save(medecin);

		return medecin;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewMedecin.class)
	public Medecin update(@PathVariable Integer id, @RequestBody Medecin medecin) {
		if (id != medecin.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		medecin = daoCompte.save(medecin);

		return medecin;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompte.deleteById(id);
	}
}
