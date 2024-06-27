package com.invoice.branches.validations.anotations;

import com.invoice.branches.validations.validator.ValidEmailBranchValidator;
import com.invoice.branches.validations.validator.ValidPhoneBranchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidPhoneBranchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidPhoneBranch {
    String message() default "{custom.phone-validation-branch.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
