package poudlard.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import poudlard.model.Baguette;



public class BaguetteValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Baguette.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Baguette baguette = (Baguette) target;
		
		if(!baguette.getNom().isBlank()) {
			errors.rejectValue("nom","Le nom est vide");
		}
	}
}
