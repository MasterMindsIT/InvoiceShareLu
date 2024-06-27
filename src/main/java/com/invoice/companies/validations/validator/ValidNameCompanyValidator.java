package com.invoice.companies.validations.validator;

import com.invoice.companies.validations.anotations.ValidNameCompany;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameCompanyValidator implements ConstraintValidator<ValidNameCompany, String> {
    @Override
    public void initialize(ValidNameCompany constraintAnnotation) {
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
