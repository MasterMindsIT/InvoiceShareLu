package com.invoice.discount;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal; // Cambiado de double a BigDecimal para mayor precisión
import java.time.ZonedDateTime; // Usado para fechas con información de hora

@JsonInclude(JsonInclude.Include.NON_NULL)
public record DiscountDTO(
        Long id,
        String name,
        String description,
        String type,
        BigDecimal percentage,
        String conditions,
        ZonedDateTime startDate, // Cambiado de LocalDate a ZonedDateTime para incluir información de hora
        ZonedDateTime endDate, // Cambiado de Date a ZonedDateTime para consistencia
        Boolean isActive
) {}
