package com.invoice.brands.validations.anotations;


import com.invoice.brands.validations.validators.ValidDescriptionBrandValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDescriptionBrandValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidDescriptionBrand {
    String message() default "{custom.description-validation-brand.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
