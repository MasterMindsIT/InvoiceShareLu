package com.invoice.categories.validations.validators;

import com.invoice.categories.validations.anotations.ValidDescriptionCategory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDescriptionCategoryValidator  implements ConstraintValidator<ValidDescriptionCategory,String> {
    @Override
    public void initialize(ValidDescriptionCategory constraintAnnotation) {
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
        if(value.length() > 200){
            return false;
        }

        // Value cannot be less than 3
        if(value.length() < 10){
            return false;
        }
        return true;
    }
}
