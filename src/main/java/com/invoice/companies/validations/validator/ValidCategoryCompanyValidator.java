package com.invoice.companies.validations.validator;

import com.invoice.companies.validations.anotations.ValidCategoryCompany;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryCompanyValidator implements ConstraintValidator<ValidCategoryCompany,String> {
    @Override
    public void initialize(ValidCategoryCompany constraintAnnotation) {
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
