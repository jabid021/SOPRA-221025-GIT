package hopital.web;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import hopital.model.Patient;
import hopital.model.Views;
import hopital.model.Visite;
import hopital.repository.IPatientRepository;
import hopital.repository.IVisiteRepository;
import hopital.web.dto.PatientDTO;
import hopital.web.dto.VisiteDTO;


@RestController
@RequestMapping("/patients")
@CrossOrigin("*")
public class PatientResource {

	@Autowired
	private IPatientRepository repoPatient;
	
	@Autowired
	private IVisiteRepository daoVisite;

	@GetMapping("")
	@JsonView(Views.ViewPatient.class)
	public List<Patient> findAll() {
		List<Patient> patients = repoPatient.findAll();

		return patients;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public Patient findById(@PathVariable Integer id) {
		Optional<Patient> optPatient = repoPatient.findById(id);

		if (optPatient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optPatient.get();
	}
	
	@GetMapping("/{id}/detail")				//JJ
	public PatientDTO findDTOById(@PathVariable Integer id) {
		Optional<Patient> optPatient = repoPatient.findById(id);

		if (optPatient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		Patient patient = optPatient.get();
		PatientDTO patientDTO = new PatientDTO();
		VisiteDTO visitedto = new VisiteDTO();
		
		patientDTO.setIdPatient(patient.getId());
		patientDTO.setNumeroSecuriteSociale(patient.getNumeroSecuriteSociale());
		patientDTO.setNom(patient.getNom());
		patientDTO.setPrenom(patient.getPrenom());
		
		List<Visite> visites = daoVisite.findAllByPatient(patientDTO.getIdPatient());
		List<VisiteDTO> visitesDTO = new ArrayList<>();
		
		for (Visite visite : visites) {
		
			visitedto.setIdVisite(visite.getId());
			visitedto.setSalle(visite.getSalle());
			visitedto.setDateVisite(visite.getDateVisite());
			visitedto.setPrix(visite.getPrix());
			visitedto.setIdentifiantMedecin(visite.getMedecin().getId());
			visitedto.setLoginMedecin(visite.getMedecin().getLogin());
			
			visitesDTO.add(visitedto);
		}
			patientDTO.setVisites(visitesDTO);
			return patientDTO;
	}

	
	@GetMapping("/{SS}")
	@JsonView(Views.ViewPatient.class)
	public Patient findBySS(@PathVariable String numeroSecuriteSociale) {
		Optional<Patient> optPatient = repoPatient.findBySS(numeroSecuriteSociale);

		if (optPatient.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optPatient.get();
	}

	@PostMapping("")
	@JsonView(Views.ViewPatient.class)
	public Patient create(@Valid @RequestBody Patient patient, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le patient n'a pu être créé");
		}

		patient = repoPatient.save(patient);

		return patient;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPatient.class)
	public Patient update(@PathVariable Integer id, @RequestBody Patient patient) {
		if (id != patient.getId() || !repoPatient.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		patient = repoPatient.save(patient);

		return patient;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!repoPatient.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		repoPatient.deleteById(id);
	}
}
