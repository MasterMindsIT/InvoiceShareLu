package com.invoice.branches.validations.anotations;

import com.invoice.branches.validations.validator.ValidNameBranchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameBranchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidNameBranch {
    String message() default "{custom.name-validation-branch.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
