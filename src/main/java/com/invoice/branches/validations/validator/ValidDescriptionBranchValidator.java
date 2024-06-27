package com.invoice.branches.validations.validator;

import com.invoice.branches.validations.anotations.ValidDescriptionBranch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionBranchValidator  implements ConstraintValidator<ValidDescriptionBranch, String> {
    @Override
    public void initialize(ValidDescriptionBranch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null){
            return false;
        }

        if(value.isEmpty()){
            return false;
        }

        if(value.length() > 200){
            return false;
        }

        if(value.length() < 10){
            return false;
        }
        return true;
    }
}
