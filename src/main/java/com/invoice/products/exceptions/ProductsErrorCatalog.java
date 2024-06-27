package com.invoice.products.exceptions;

import lombok.Getter;

@Getter
public enum ProductsErrorCatalog {
    PRODUCT_NOT_FOUND("ERR_PRODUCT_001", "Product not found."),
    INVALID_PRODUCT("ERR_PRODUCT_002", "Invalid Product parameters."),
    GENERIC_PRODUCT_ERROR("ERR_PRODUCT_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    ProductsErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
