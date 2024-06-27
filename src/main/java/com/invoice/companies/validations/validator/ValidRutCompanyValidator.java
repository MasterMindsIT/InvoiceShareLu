package com.invoice.companies.validations.validator;

import com.invoice.companies.validations.anotations.ValidRutCompany;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidRutCompanyValidator implements ConstraintValidator<ValidRutCompany, String> {
    @Override
    public void initialize(ValidRutCompany constraintAnnotation) {
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

        if(value.length() > 15){
            return false;
        }

        if(value.length() < 8){
            return false;
        }
        return true;
    }
}
