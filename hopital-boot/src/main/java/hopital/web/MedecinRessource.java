package hopital.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hopital.repository.ICompteRepository;
import hopital.repository.IPatientRepository;
import hopital.repository.IVisiteRepository;

@RestController
@RequestMapping("/medecin")
@CrossOrigin("*")
public class MedecinRessource {
	
	@Autowired
	private ICompteRepository daoCompte;
	private IPatientRepository daoPatient;
	private IVisiteRepository daoVisite;

}
