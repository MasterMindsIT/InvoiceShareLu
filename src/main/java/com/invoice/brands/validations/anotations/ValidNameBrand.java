package com.invoice.brands.validations.anotations;

import com.invoice.brands.validations.validators.ValidNameBrandValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameBrandValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNameBrand {
    String message() default "{custom.name-validation-brand.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
