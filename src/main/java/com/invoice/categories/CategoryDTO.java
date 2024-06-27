package com.invoice.categories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.categories.validations.anotations.ValidDescriptionCategory;
import com.invoice.categories.validations.anotations.ValidNameCategory;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CategoryDTO(
        Long id,
        @ValidNameCategory String name,
        @ValidDescriptionCategory String description) {
}
