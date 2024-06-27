package com.invoice.brands.validations.validators;

import com.invoice.brands.validations.anotations.ValidNameBrand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameBrandValidator implements ConstraintValidator<ValidNameBrand,String> {

    @Override
    public void initialize(ValidNameBrand constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // Value cannot be Null
        if(value == null){
            return false;
        }

        // Value cannot be Empty
        if(value.isEmpty()){
            return false;
        }

        // Value cannot be greater than 15
        if(value.length() > 20){
            return false;
        }

        // Value cannot be less than 3
        if(value.length() < 3){
            return false;
        }
        return true;
    }
}
