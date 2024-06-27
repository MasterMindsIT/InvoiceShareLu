package com.invoice.brands.validations.validators;

import com.invoice.brands.validations.anotations.ValidDescriptionBrand;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionBrandValidator implements ConstraintValidator<ValidDescriptionBrand, String> {
    @Override
    public void initialize(ValidDescriptionBrand constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String description, ConstraintValidatorContext constraintValidatorContext) {

        if(description == null){
            return false;
        }

        if(description.isEmpty()){
            return false;
        }

        if(description.length() > 200){
            return false;
        }

        if(description.length() < 10){
            return false;
        }
        return true;
    }
}
