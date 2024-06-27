package com.invoice.companies.validations.anotations;

import com.invoice.companies.validations.validator.ValidCategoryCompanyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidCategoryCompanyValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidCategoryCompany {
    String message() default "{custom.category-validation-company.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
