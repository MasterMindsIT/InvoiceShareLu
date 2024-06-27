package com.invoice.branches.validations.validator;

import com.invoice.branches.validations.anotations.ValidNameBranch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameBranchValidator  implements ConstraintValidator<ValidNameBranch, String> {
    @Override
    public void initialize(ValidNameBranch constraintAnnotation) {
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

        if(value.length() > 30){
            return false;
        }

        if(value.length() < 2){
            return false;
        }
        return true;
    }
}
