package com.invoice.branches.validations.validator;

import com.invoice.branches.validations.anotations.ValidAddresBranch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidAddresBranchValidator implements ConstraintValidator<ValidAddresBranch,String> {
    @Override
    public void initialize(ValidAddresBranch constraintAnnotation) {
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
