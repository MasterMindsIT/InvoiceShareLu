package com.invoice.inventories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record InventoryDTO(

        @JsonProperty("id") // Explicit JSON property name mapping
        Long id,

        @JsonProperty("user_id")
        Long userId,

        @JsonProperty("product_id")
        Long productId,

        @JsonProperty("sucursal_id")
        Long sucursalId,

        @JsonProperty("reason_id")
        Long reasonId,

        Integer adjust,

        String description,

        Integer quantity,

        String location,

        Integer reorderLevel,

        ZonedDateTime lastUpdated
) {
}