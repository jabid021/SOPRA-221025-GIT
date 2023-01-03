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

import poudlard.model.Sort;
import poudlard.model.Views;
import poudlard.repository.ISortRepository;

@RestController
@RequestMapping("/sorts")
@CrossOrigin("*")
public class SortController {
	
	@Autowired
	private ISortRepository daoSort;
	
	@GetMapping("")
	@JsonView(Views.ViewSort.class)
	public List<Sort> findAll() {
		List<Sort> sorts = daoSort.findAll();

		return sorts;
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewSort.class)
	public Sort findById(@PathVariable Integer id) {
		Optional<Sort> optSort = daoSort.findById(id);

		if (optSort.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optSort.get();
	}
}
