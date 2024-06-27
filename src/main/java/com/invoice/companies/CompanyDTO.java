package com.invoice.companies;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.companies.validations.anotations.ValidCategoryCompany;
import com.invoice.companies.validations.anotations.ValidNameCompany;
import com.invoice.companies.validations.anotations.ValidRutCompany;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CompanyDTO (
        Long id,
        @ValidNameCompany String name,
        @ValidCategoryCompany String category,
        @ValidRutCompany String rut,
        Integer user_id,
        Integer taxes_id
){
}