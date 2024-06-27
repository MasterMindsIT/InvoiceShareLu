package com.invoice.inventories.exceptions;

import lombok.Getter;

@Getter
public enum InventoryErrorCatalog {
    INVENTORY_NOT_FOUND("ERR_INVENTORY_001", "Inventory not found."),
    INVALID_INVENTORY("ERR_INVENTORY_002", "Invalid Inventories parameters."),
    GENERIC_INVENTORY_ERROR("ERR_INVENTORY_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    InventoryErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}