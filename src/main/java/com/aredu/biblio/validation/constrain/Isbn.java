package com.aredu.biblio.validation.constrain;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.aredu.biblio.validation.IsbnValidation;

@Documented
@Constraint(validatedBy = IsbnValidation.class)
@Target( {ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Isbn {
	
	String message() default "Isbn inválido";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
