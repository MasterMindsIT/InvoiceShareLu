package com.invoice.categories.validations.anotations;


import com.invoice.categories.validations.validators.ValidNameCategoryValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameCategoryValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface  ValidNameCategory {
    String message() default "{custom.name-validation-category.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
