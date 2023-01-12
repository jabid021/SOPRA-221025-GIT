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

	

	@PostMapping("")
	@JsonView(Views.ViewInscription.class)
	public Compte create(@Valid @RequestBody Compte inscription, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le inscription n'a pu être créé");
		}

		inscription = daoCompte.save(inscription);

		return inscription;
	}
}
