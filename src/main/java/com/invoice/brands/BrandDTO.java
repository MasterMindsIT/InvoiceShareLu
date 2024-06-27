package com.invoice.brands;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.brands.validations.anotations.ValidDescriptionBrand;
import com.invoice.brands.validations.anotations.ValidNameBrand;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BrandDTO ( Long id,
                         @ValidNameBrand String name,
                         @ValidDescriptionBrand String description){
}

