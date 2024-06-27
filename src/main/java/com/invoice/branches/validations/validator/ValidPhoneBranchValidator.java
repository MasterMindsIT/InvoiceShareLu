package com.invoice.branches.validations.validator;

import com.invoice.branches.validations.anotations.ValidPhoneBranch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhoneBranchValidator implements ConstraintValidator<ValidPhoneBranch, String> {
    @Override
    public void initialize(ValidPhoneBranch constraintAnnotation) {
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

        if(value.length() > 16){
            return false;
        }

        if(value.length() < 6){
            return false;
        }
        return true;
    }
}
