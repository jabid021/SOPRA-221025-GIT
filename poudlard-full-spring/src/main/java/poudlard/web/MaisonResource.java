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

import poudlard.model.Maison;
import poudlard.model.Views;
import poudlard.repository.IMaisonRepository;
//import quest.model.Views;


@RestController
@RequestMapping("/maisons")
@CrossOrigin("*")
public class MaisonResource {

	@Autowired
	private IMaisonRepository daoMaison;

	@GetMapping("")
	@JsonView(Views.ViewMaison.class)
	public List<Maison> findAll() {
		List<Maison> maisons = daoMaison.findAll();

		return maisons;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewMaison.class)
	public Maison findById(@PathVariable Integer id) {
		Optional<Maison> optMaison = daoMaison.findById(id);

		if (optMaison.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optMaison.get();
	}
	

}
