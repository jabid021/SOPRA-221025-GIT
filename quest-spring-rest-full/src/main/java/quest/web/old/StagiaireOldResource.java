package quest.web.old;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
