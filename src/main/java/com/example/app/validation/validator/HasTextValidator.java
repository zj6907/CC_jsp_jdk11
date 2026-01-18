package com.example.app.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.example.app.validation.annotation.HasTextValidation;

public class HasTextValidator implements ConstraintValidator<HasTextValidation, String> {

	@Override
	public void initialize(HasTextValidation constraintAnnotation) {
		// optional
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return StringUtils.hasText(value);
	}

}
