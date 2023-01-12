package hopital.web;

import java.util.List;
import java.util.Optional;
import java.util.Queue;

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
import hopital.model.Visite;
import hopital.repository.ICompteRepository;
import hopital.repository.IPatientRepository;
import hopital.repository.IVisiteRepository;
import hopital.service.FileAttenteService;

@RestController
@RequestMapping("/medecin")
@CrossOrigin("*")
public class MedecinRessource {

	@Autowired
	private ICompteRepository daoCompte;
	@Autowired
	private IPatientRepository daoPatient;
	@Autowired
	private IVisiteRepository daoVisite;
	@Autowired
	private FileAttenteService fileatente;

	@GetMapping("/visite")
	public List<Visite>findAllVisites(){
		List<Visite> visites =daoVisite.findAll();
		return visites;
	}
	@GetMapping("/fileattente")
	public Queue<Patient> findAll(){
		Queue<Patient> patients = fileatente.getFileAttente();
		return patients;
	}

	@PostMapping("/{idMedecin}/recevoir")
	public void recevoirPatient(@PathVariable Integer Idmedecin){
		Queue<Patient> patients = fileatente.getFileAttente();
		Patient patient = patients.peek();
		Optional<Compte> optmedecin = daoCompte.findById(Idmedecin);
		Medecin medecin = (Medecin) optmedecin.get();
		Visite visite = new Visite(patient, medecin);
		visite=daoVisite.save(visite);
		fileatente.removePatient(patient);
	}


}
