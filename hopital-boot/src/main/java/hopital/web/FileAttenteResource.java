package hopital.web;

import java.util.Optional;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import hopital.model.Patient;
import hopital.model.Views;
import hopital.repository.IPatientRepository;
import hopital.service.FileAttenteService;


@RestController
@RequestMapping("/file_attente")
@CrossOrigin("*")
public class FileAttenteResource {

	@Autowired
	private IPatientRepository repoPatient;
	
	@Autowired
	private FileAttenteService fileAttente;
	

	@GetMapping("")
	@JsonView(Views.ViewPatient.class)
	public Queue<Patient> getFileAttente() {
		Queue<Patient> filedAtt = fileAttente.getFileAttente();
		
		return filedAtt;
	}

	
	@GetMapping("/peek")
	@JsonView(Views.ViewPatient.class)
	public Patient peekFileAttente() {
		Patient prochainPatient = fileAttente.peekPatient();
		return prochainPatient;
	}
	

	@PostMapping("/add")
	@JsonView(Views.ViewPatient.class)
	public Patient addPatient(@RequestBody Patient patient) {
		fileAttente.addPatient(patient);
		System.out.println(patient.toString());
		
		return fileAttente.peekPatient();
	}

	@DeleteMapping("/poll")
	@JsonView(Views.ViewPatient.class)
	public Patient pollPatient() {
		return(fileAttente.pollPatient());
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public void removePatient(@PathVariable Integer idPatient) {
		Optional<Patient> optPatient = repoPatient.findById(idPatient);
		if (optPatient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		fileAttente.removePatient(optPatient.get());
	}
}
