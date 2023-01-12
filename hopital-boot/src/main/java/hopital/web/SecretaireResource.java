package hopital.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

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

import hopital.model.Patient;
import hopital.model.Secretaire;
import hopital.model.Views;
import hopital.repository.ICompteRepository;
import hopital.repository.IPatientRepository;
import hopital.service.FileAttenteService;


@RestController
@RequestMapping("/secretaire")
@CrossOrigin("*")
public class SecretaireResource {
	
	@Autowired
	ICompteRepository daoCompte;
	
	@Autowired
	IPatientRepository daoPatient;
	
	private FileAttenteService fileattente;
	
	
	@GetMapping("")
	@JsonView(Views.ViewSecretaire.class)
	public Queue<Patient> findAll() {
		Queue<Patient> patients = fileattente.getFileAttente();

		return patients;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSecretaire.class)
	public Patient findById(@PathVariable Integer id) {
		Optional<Patient> optPatient = daoPatient.findById(id);

		if (optPatient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optPatient.get();
	}
	

	


	@PostMapping("")
	@JsonView(Views.ViewSecretaire.class)
	public Patient create(@Valid @RequestBody Patient patient, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le secretaire n'a pu être créé");
		}

		patient =daoPatient.save(patient); 
		
		fileattente.addPatient(patient);

		return patient;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSecretaire.class)
	public Patient update(@PathVariable Integer id, @RequestBody Patient patient) {
		if (id != patient.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		patient = daoPatient.save(patient);

		return patient;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoPatient.deleteById(id);
	}
}
