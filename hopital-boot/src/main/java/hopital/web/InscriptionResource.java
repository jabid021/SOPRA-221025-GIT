package hopital.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Secretaire;
import hopital.model.Views;
import hopital.repository.ICompteRepository;



@RestController
@RequestMapping("/inscriptions")
@CrossOrigin("*")
public class InscriptionResource {

	@Autowired
	private ICompteRepository daoCompte;



	@PostMapping("")
	@JsonView(Views.ViewInscription.class)
	public Compte create(@Valid @RequestBody CompteDTO inscription, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le inscription n'a pu être créé");
		}
		if(inscription.getChoix()==1) {
			Medecin medecin=new Medecin(inscription.getLogin(),inscription.getPassword());
			medecin= daoCompte.save(medecin);
			return medecin;
		}else {
			Secretaire sec = new Secretaire(inscription.getLogin(),inscription.getPassword());
			sec= daoCompte.save(sec);
			return sec;
		}
	}
}
