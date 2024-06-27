package com.invoice.branches.validations.anotations;

import com.invoice.branches.validations.validator.ValidAddresBranchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidAddresBranchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidAddresBranch {
    String message() default "{custom.addres-validation-branch.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
