package hopital.web;
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
import hopital.model.Compte;
import hopital.model.Views;
import hopital.repository.ICompteRepository;

@RestController
@RequestMapping("/connexions")
@CrossOrigin("*")
public class ConnexionResource {
	

		@Autowired
		private ICompteRepository daoConnexion;

		@GetMapping("")
		@JsonView(Views.ViewConnexion.class)
		public List<Compte> findAll() {
			List<Compte> connexions = daoConnexion.findAll();

			return connexions;
		}

		@GetMapping("/{id}")
		@JsonView(Views.ViewConnexionDetail.class)
		public Compte findById(@PathVariable Integer id) {
			Optional<Compte> optConnexion = daoConnexion.findById(id);

			if (optConnexion.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			return optConnexion.get();
		}


	}


