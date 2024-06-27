package com.invoice.companies.validations.anotations;

import com.invoice.companies.validations.validator.ValidNameCompanyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameCompanyValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNameCompany {
    String message() default "{custom.name-validation-company.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
