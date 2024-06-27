package com.invoice.companies.validations.anotations;

import com.invoice.companies.validations.validator.ValidRutCompanyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidRutCompanyValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidRutCompany {
    String message() default "{custom.rut-validation-company.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
