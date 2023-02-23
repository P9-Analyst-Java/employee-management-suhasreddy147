package com.deloitte.portal.validator;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BloodGroupValidator implements ConstraintValidator<BloodGroup, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<String> list=new ArrayList<>();
		list.add("O+");
		list.add("O-");
		list.add("A+");
		list.add("A-");
		list.add("B+");
		list.add("B-");
		list.add("AB+");
		list.add("AB-");
		return list.contains(value);
	}

}
