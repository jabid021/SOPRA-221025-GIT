package hopital.web;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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



		@PostMapping("")
		@JsonView(Views.ViewConnexionDetail.class)
		public Compte login(@RequestBody AuthDTO connectDTO) {
			Optional<Compte> optConnexion = daoConnexion.findByLoginAndPassword(connectDTO.getLogin(), connectDTO.getPassword());

			if (optConnexion.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}

			return optConnexion.get();
			
		}

	}


