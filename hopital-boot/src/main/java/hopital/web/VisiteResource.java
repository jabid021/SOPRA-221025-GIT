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
	private IVisiteRepository daoVisite;
	
//	@Autowired
//	private ICompteRepository daoCompte;
	
	@GetMapping("")
	@JsonView(Views.ViewVisite.class)
 	public List<Visite> findAll() {
		List<Visite> visites = daoVisite.findAll();

		return visites;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewVisite.class)
	public Visite findById(@PathVariable Integer id) {
		Optional<Visite> optVisite = daoVisite.findById(id);

		if (optVisite.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optVisite.get();
	}

	@GetMapping("/{id}/with-medecin")
	@JsonView(Views.ViewVisiteWithMedecin.class)
	public Visite findByIdWithMedecin(@PathVariable Integer id) {
		Optional<Visite> optVisite = daoVisite.findByIdWithMedecin(id);

		if (optVisite.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optVisite.get();
	}

	@GetMapping("/{id}/with-patient")
	@JsonView(Views.ViewVisiteWithPatient.class)
	public Visite findByIdWithPatient(@PathVariable Integer id) {
		Optional<Visite> optVisite = daoVisite.findByIdWithPatient(id);

		if (optVisite.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optVisite.get();
	}
	
//	@GetMapping("/{id}/with-all")
//	@JsonView(Views.ViewVisiteWithAll.class)
//	public Visite findByIdWithAll(@PathVariable Integer id) {
//		Optional<Visite> optVisite = daoVisite.findByIdWithPatient(id);		
//
//		if (optVisite.isEmpty()) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
//
//		Visite visite = optVisite.get();
//		
//		Medecin medecin = daoCompte.findMedecinById(id);
//		
//		visite.setPatient(patient);
//
//		return visite;
//	}
	
	@PostMapping("")
	@JsonView(Views.ViewVisite.class)
	public Visite create(@Valid @RequestBody Visite visite, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le visite n'a pu être créé");
		}

		visite = daoVisite.save(visite);

		return visite;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewVisite.class)
	public Visite update(@PathVariable Integer id, @RequestBody Visite visite) {
		if (id != visite.getId() || !daoVisite.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		visite = daoVisite.save(visite);

		return visite;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoVisite.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoVisite.deleteById(id);
	}
}