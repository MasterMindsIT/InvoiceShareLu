package com.invoice.products;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductsDTO (
        Long id,
        String name,
        String description,
        float price,
        Long providerId,
        Long brandId,
        Long categoryId){
}