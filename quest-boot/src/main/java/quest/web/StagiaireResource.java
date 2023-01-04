package quest.web;

import java.lang.reflect.Field;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;
import quest.model.Views;
import quest.web.dto.StagiaireDTO;

@RestController
@RequestMapping("/stagiaires")
@CrossOrigin("*")
public class StagiaireResource {

	@Autowired
	private IDAOStagiaire daoStagiaire;

	@GetMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = daoStagiaire.findAll();

		return stagiaires;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewStagiaireDetail.class)
	public Stagiaire findById(@PathVariable Integer id) {
		Optional<Stagiaire> optStagiaire = daoStagiaire.findById(id);

		if (optStagiaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optStagiaire.get();
	}

	@GetMapping("/{id}/dto")
	public StagiaireDTO findDTOById(@PathVariable Integer id) {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Optional<Stagiaire> optStagiaire = daoStagiaire.findById(id);

		if (optStagiaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		Stagiaire stagiaire = optStagiaire.get();

		StagiaireDTO stagiaireDTO = new StagiaireDTO();

		stagiaireDTO.setIdentifiant(stagiaire.getId());
		stagiaireDTO.setNom(stagiaire.getNom());
		stagiaireDTO.setPrenom(stagiaire.getPrenom());
		stagiaireDTO.setEmail(stagiaire.getEmail());
		stagiaireDTO.setIdFiliere(stagiaire.getFiliere().getId());
		stagiaireDTO.setNomFiliere(stagiaire.getFiliere().getLibelle());
		stagiaireDTO.setDebutFiliere(stagiaire.getFiliere().getDebut());
		stagiaireDTO.setFinFiliere(stagiaire.getFiliere().getFin());
		stagiaireDTO.setDebutFiliereString(dtf.format(stagiaire.getFiliere().getDebut()));
		stagiaireDTO.setFinFiliereString(dtf.format(stagiaire.getFiliere().getFin()));

		return stagiaireDTO;
	}

	@PostMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire create(@Valid @RequestBody Stagiaire stagiaire, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le stagiaire n'a pu être créé");
		}

		stagiaire = daoStagiaire.save(stagiaire);

		return stagiaire;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire update(@PathVariable Integer id, @RequestBody Stagiaire stagiaire) {
		if (id != stagiaire.getId() || !daoStagiaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		stagiaire = daoStagiaire.save(stagiaire);

		return stagiaire;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
		Optional<Stagiaire> optStagiaire = daoStagiaire.findById(id);

		if (optStagiaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		final Stagiaire stagiaire = optStagiaire.get();

//		if(fields.containsKey("nom")) {
//			stagiaire.setNom((String) fields.get("nom"));
//		}
//		
//		if(fields.containsKey("prenom")) {
//			stagiaire.setPrenom((String) fields.get("prenom"));
//		}
//
//		if(fields.containsKey("email")) {
//			stagiaire.setEmail((String) fields.get("email"));
//		}

		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Stagiaire.class, key);
			if (field == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Propriété : " + key + "non trouvée");
			}
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, stagiaire, value);
		});

		return daoStagiaire.save(stagiaire);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoStagiaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoStagiaire.deleteById(id);
	}
}
