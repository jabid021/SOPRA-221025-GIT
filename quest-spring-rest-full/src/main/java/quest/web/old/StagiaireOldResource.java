package quest.web.old;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import quest.dao.IDAOStagiaire;
import quest.model.Stagiaire;

@Controller
public class StagiaireOldResource {

	@Autowired
	private IDAOStagiaire daoStagiaire;

	@GetMapping("/old/stagiaires")
	public ResponseEntity<List<Stagiaire>> findall() {
		List<Stagiaire> stagiaires = daoStagiaire.findAll();
		
		return new ResponseEntity<>(stagiaires, HttpStatus.OK);
	}

}
