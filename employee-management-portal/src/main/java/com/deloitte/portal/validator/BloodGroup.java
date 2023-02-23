package com.deloitte.portal.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = BloodGroupValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )  
@Retention(RetentionPolicy.RUNTIME) 
public @interface BloodGroup {
	public String message() default "Must be M/F/ND"; 
	public Class<?>[] groups() default {};  
	public Class<? extends Payload>[] payload() default {};
}
