package com.invoice.taxes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.discount.DiscountDTO;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TaxesDTO (
        Long id,
        String name,
        Double value,
        String description,
        Boolean isActive,
        List<DiscountDTO> discounts // Lista de descuentos asociados, usando un DTO para optimizar la carga de datos
) {}


