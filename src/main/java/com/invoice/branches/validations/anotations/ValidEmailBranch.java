package com.invoice.branches.validations.anotations;


import com.invoice.branches.validations.validator.ValidEmailBranchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidEmailBranchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidEmailBranch {
    String message() default "{custom.email-validation-branch.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
