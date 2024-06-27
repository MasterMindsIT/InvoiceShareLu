package com.invoice.categories.validations.anotations;

import com.invoice.categories.validations.validators.ValidDescriptionCategoryValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDescriptionCategoryValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidDescriptionCategory {
    String message() default "{custom.description-validation-category.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
