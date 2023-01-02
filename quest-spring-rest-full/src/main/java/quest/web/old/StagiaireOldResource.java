package quest.web.old;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

@Controller
@RequestMapping("/old/stagiaires")
@CrossOrigin("*")
public class StagiaireOldResource {

	@Autowired
	private IDAOStagiaire daoStagiaire;

	@GetMapping("")
	public ResponseEntity<List<Stagiaire>> findAll() {
		List<Stagiaire> stagiaires = daoStagiaire.findAll();

		return new ResponseEntity<>(stagiaires, HttpStatus.OK);
	}
	
	@GetMapping("/bis")
	@ResponseBody
	public List<Stagiaire> findAllBis() {
		List<Stagiaire> stagiaires = daoStagiaire.findAll();

		return stagiaires;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Stagiaire> findById(@PathVariable Integer id) {
		Optional<Stagiaire> optStagiaire = daoStagiaire.findById(id);
		
		if(optStagiaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(optStagiaire.get(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Stagiaire> create(@Valid @RequestBody Stagiaire stagiaire, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le stagiaire n'a pu être créé");
		}
		
		stagiaire = daoStagiaire.save(stagiaire);
		
		return new ResponseEntity<>(stagiaire, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Stagiaire> update(@PathVariable Integer id, @RequestBody Stagiaire stagiaire) {
		if(id != stagiaire.getId() || !daoStagiaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		stagiaire = daoStagiaire.save(stagiaire);
		
		return new ResponseEntity<>(stagiaire, HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Stagiaire> partialUpdate(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
		Optional<Stagiaire> optStagiaire = daoStagiaire.findById(id);
		
		if(optStagiaire.isEmpty()) {
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
			Field field = ReflectionUtils.findField(Stagiaire.class , key);
			if(field == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Propriété : " + key + "non trouvée" );
			}
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, stagiaire, value);
		});
		
		
		Stagiaire stagiaireResult = daoStagiaire.save(stagiaire);
		
		return new ResponseEntity<>(stagiaireResult, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if(!daoStagiaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		daoStagiaire.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
