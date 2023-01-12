package hopital.web;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;
import hopital.model.Visite;
import hopital.repository.ICompteRepository;
import hopital.repository.IPatientRepository;
import hopital.repository.IVisiteRepository;
import hopital.service.FileAttenteService;



@RestController
@RequestMapping("")
@CrossOrigin("*")
public class ReservationResource {
	
@Autowired
private FileAttenteService attenteService;
@Autowired
private ICompteRepository compteRepository;
@Autowired
private IPatientRepository patientRepository;
@Autowired
private IVisiteRepository visiteRepository;

	@PostMapping("/medecin")
	public Compte inscription( @RequestBody Medecin medecin) {
		medecin = compteRepository.save(medecin);
		return medecin;
	}
	
	@PostMapping("/secretaire")
	public Compte inscription( @RequestBody Secretaire sec) {
		sec = compteRepository.save(sec);
		return sec;
	}

	@PostMapping("/patient")
	public Patient inscription( @RequestBody Patient patient) {
		patient = patientRepository.save(patient);
		attenteService.addPatient(patient);
		return patient;
	}
	
	
	@GetMapping("medecin/{login}/{password}")
	public Compte loginMed(@PathVariable String login,@PathVariable String password) {
		Compte compte = null;
		compte = compteRepository.findByLoginAndPassword(login,password).get();
		return compte;
	}
	@GetMapping("secretaire/{login}/{password}")
	public Compte loginsec(@PathVariable String login,@PathVariable String password) {
		Compte compte = null;
		compte = compteRepository.findByLoginAndPassword(login,password).get();
		return compte;
	}
	
	
	@PostMapping("/valider")
	public Visite ajoutVisite(@RequestBody Patient patient, @RequestBody Medecin medecin) {
		Visite visite = new Visite(patient, medecin);
		if (medecin.getVisites()!=null) {
			medecin.getVisites().add(visite);
		}
		visite = visiteRepository.save(visite);
		return visite;
	}
	
	@PostMapping("/PrendreEnCharge")
	public Patient prendreEnCharge() {
		Patient p = attenteService.pollPatient();
		return p;
	}
	
	
	
	@GetMapping("/fillDatt")
	public Queue<Patient> listeDatt() {
		return attenteService.getFileAttente();
	}
	
	
	
	

}