package com.deloitte.portal.validator;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DobValidator implements ConstraintValidator<Dob, Date> {

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		if(Period.between(value.toLocalDate(),LocalDate.now()).getYears()>=20) {
			return true;
		}
		else{
			return false;
		}
	}

}
