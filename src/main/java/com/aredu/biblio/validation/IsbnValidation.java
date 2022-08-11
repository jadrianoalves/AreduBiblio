package com.aredu.biblio.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.aredu.biblio.validation.constrain.Isbn;

public class IsbnValidation implements ConstraintValidator<Isbn, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String isbn = value == null ? "": value;
		return isbn.matches("[0-9]{10}");
	}

}
