package com.invoice.branches.validations.anotations;

import com.invoice.branches.validations.validator.ValidAddresBranchValidator;
import com.invoice.branches.validations.validator.ValidDescriptionBranchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidDescriptionBranchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidDescriptionBranch {
    String message() default "{custom.description-validation-branch.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
