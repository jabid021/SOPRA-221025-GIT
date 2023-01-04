package quest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import quest.dao.IDAOUtilisateur;
import quest.model.Utilisateur;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IDAOUtilisateur daoUtilisateur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> optUtilisateur = daoUtilisateur.findByIdentifiant(username);

		if (optUtilisateur.isPresent()) {
			return new CustomUserDetails(optUtilisateur.get());
		} else {
			throw new UsernameNotFoundException(username + " Inconnu");
		}
	}

}
