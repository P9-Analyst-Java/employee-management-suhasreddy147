package com.deloitte.portal.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = DobValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )  
@Retention(RetentionPolicy.RUNTIME) 
public @interface Dob {

	public String message() default "Age must be >=20"; 
	public Class<?>[] groups() default {};  
	public Class<? extends Payload>[] payload() default {}; 
}
