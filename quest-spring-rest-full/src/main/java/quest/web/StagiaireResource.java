package quest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

@RestController
public class StagiaireResource {

	@Autowired
	private IDAOStagiaire daoStagiaire;

	@GetMapping("/stagiaires")
	public List<Stagiaire> findall() {
		List<Stagiaire> stagiaires = daoStagiaire.findAll();

		return stagiaires;
	}

}
