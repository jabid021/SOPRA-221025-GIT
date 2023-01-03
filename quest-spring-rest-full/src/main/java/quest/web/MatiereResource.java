package quest.web;

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

import quest.dao.IDAOMatiere;
import quest.model.Matiere;

@RestController
@RequestMapping("/matieres")
@CrossOrigin("*")
public class MatiereResource {

	@Autowired
	private IDAOMatiere daoMatiere;

	@GetMapping("")
	public List<Matiere> findall() {
		List<Matiere> matieres = daoMatiere.findAll();

		return matieres;
	}

	@GetMapping("/{id}")
	public Matiere findById(@PathVariable Integer id) {
		Optional<Matiere> optMatiere = daoMatiere.findById(id);

		if (optMatiere.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optMatiere.get();
	}

	@PostMapping("")
	public Matiere create(@Valid @RequestBody Matiere matiere, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le matiere n'a pu être créé");
		}

		matiere = daoMatiere.save(matiere);

		return matiere;
	}

	@PutMapping("/{id}")
	public Matiere update(@PathVariable Integer id, @RequestBody Matiere matiere) {
		if (id != matiere.getId() || !daoMatiere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		matiere = daoMatiere.save(matiere);

		return matiere;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoMatiere.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoMatiere.deleteById(id);
	}
}
