package quest.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import quest.model.Stagiaire;

public class StagiaireValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Stagiaire.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Stagiaire stagiaire = (Stagiaire) target;
		
		if(!stagiaire.getNom().isBlank() && stagiaire.getNom().contentEquals(stagiaire.getPrenom())) {
			errors.rejectValue("prenom", "prenom.doublon", "Le prénom et le nom doivent être différents");
		}
	}

}
