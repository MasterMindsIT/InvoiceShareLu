package com.invoice.providers;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProviderDTO (
         Long id,
         String rut,
         String name,
         String phone,
         String email,
         String contact){
}
