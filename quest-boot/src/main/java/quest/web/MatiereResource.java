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

import com.fasterxml.jackson.annotation.JsonView;

import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.model.Filiere;
import quest.model.Matiere;
import quest.model.Views;
import quest.web.dto.MatiereDTO;

@RestController
@RequestMapping("/matieres")
@CrossOrigin("*")
public class MatiereResource {

	@Autowired
	private IDAOMatiere daoMatiere;
	
	@Autowired
	private IDAOFiliere daoFiliere;

	@GetMapping("")
	@JsonView(Views.ViewMatiere.class)
	public List<Matiere> findAll() {
		List<Matiere> matieres = daoMatiere.findAll();

		return matieres;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewMatiere.class)
	public Matiere findById(@PathVariable Integer id) {
		Optional<Matiere> optMatiere = daoMatiere.findById(id);

		if (optMatiere.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optMatiere.get();
	}
	
	@GetMapping("/{id}/detail")
	public MatiereDTO detailById(@PathVariable Integer id) {
		Optional<Matiere> optMatiere = daoMatiere.findById(id);

		if (optMatiere.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		List<Filiere> filieres = daoFiliere.findAllByMatiere(id);
		
		Matiere matiere = optMatiere.get();
		
		MatiereDTO matiereDTO = new MatiereDTO();
		matiereDTO.setId(matiere.getId());
		matiereDTO.setNom(matiere.getLibelle());
		matiereDTO.setCodeQuest(matiere.getQuest());
		
		for(Filiere filiere : filieres) {
			matiereDTO.getFilieres().add(filiere.getId());
		}

		return matiereDTO;
	}

	@PostMapping("")
	@JsonView(Views.ViewMatiere.class)
	public Matiere create(@Valid @RequestBody Matiere matiere, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le matiere n'a pu être créé");
		}

		matiere = daoMatiere.save(matiere);

		return matiere;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewMatiere.class)
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
