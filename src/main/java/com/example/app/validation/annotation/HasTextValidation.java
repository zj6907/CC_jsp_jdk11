package com.example.app.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.app.validation.validator.HasTextValidator;

@Documented
@Constraint(validatedBy = HasTextValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface HasTextValidation {

	String message() default "value should not be empty!";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
