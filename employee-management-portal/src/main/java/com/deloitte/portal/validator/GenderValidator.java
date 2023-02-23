package com.deloitte.portal.validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.equals("M")||value.equals("F")||value.equals("ND")) {
			return true;
		}
		else
			return false;
	}

}
