package poudlard.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import poudlard.model.Competence;
import poudlard.model.Views;
import poudlard.repository.ICompetenceRepository;

@RestController
@RequestMapping("/competences")
@CrossOrigin("*")
public class CompetenceController {
	
	@Autowired
	private ICompetenceRepository daoCompetence;
	
	@GetMapping("")
	@JsonView(Views.ViewCompetence.class)
	public List<Competence> findAll() {
		List<Competence> competences = daoCompetence.findAll();

		return competences;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCompetence.class)
	public Competence findById(@PathVariable Integer id) {
		Optional<Competence> optCompetence = daoCompetence.findById(id);

		if (optCompetence.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompetence.get();
	}
	
	@GetMapping("/{id}/with-sorcier")
	@JsonView(Views.ViewCompetenceWithSorcier.class)
	public Competence findByIdWithSorcier(@PathVariable Integer id) {
		Optional<Competence> optCompetence = daoCompetence.findById(id);

		if (optCompetence.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompetence.get();
	}
	
	@GetMapping("/{id}/with-sort")
	@JsonView(Views.ViewCompetenceWithSort.class)
	public Competence findByIdWithSort(@PathVariable Integer id) {
		Optional<Competence> optCompetence = daoCompetence.findById(id);

		if (optCompetence.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompetence.get();
	}
	
	@GetMapping("/{id}/with-all")
	@JsonView(Views.ViewCompetenceWithAll.class)
	public Competence findByIdWithAll(@PathVariable Integer id) {
		Optional<Competence> optCompetence = daoCompetence.findById(id);

		if (optCompetence.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompetence.get();
	}
}
