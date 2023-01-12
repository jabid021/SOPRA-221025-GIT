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
import hopital.model.Views.ViewBase;
import hopital.repository.ICompteRepository;
import hopital.web.dto.AuthDTO;

@RestController
@RequestMapping("/comptes")
@CrossOrigin("*")
public class CompteResource {

	@Autowired
	private ICompteRepository daoCompte;

	@GetMapping("")
	@JsonView(ViewBase.class)
	public List<Compte> findAll() {
		List<Compte> comptes = daoCompte.findAll();

		return comptes;
	}

	@GetMapping("/{id}")
	@JsonView(ViewBase.class)
	public Compte findById(@PathVariable Integer id) {
		Optional<Compte> optCompte = daoCompte.findById(id);

		if (optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompte.get();
	}
	

	
		@PostMapping("/auth")
		@JsonView(ViewBase.class)
	public Compte findBy(@RequestBody AuthDTO authDTO) {
		Optional<Compte>  optcompte = daoCompte.findByLoginAndPassword(authDTO.getMail(),authDTO.getPassword());
		if (optcompte.isEmpty()){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optcompte.get();
	}
	

	@PostMapping("")
	@JsonView(ViewBase.class)
	public Compte create(@Valid @RequestBody Compte compte, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le compte n'a pu être créé");
		}

		compte = daoCompte.save(compte);

		return compte;
	}

	@PutMapping("/{id}")
	@JsonView(ViewBase.class)
	public Compte update(@PathVariable Integer id, @RequestBody Compte compte) {
		if (id != compte.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		compte = daoCompte.save(compte);

		return compte;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompte.deleteById(id);
	}
}
