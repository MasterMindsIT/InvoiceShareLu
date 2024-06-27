package com.invoice.brands.exceptions;

import lombok.Getter;

@Getter
public enum BrandsErrorCatalog {
    BRANDS_NOT_FOUND("ERR_BRANDS_001", "Brand not found."),
    INVALID_BRANDS("ERR_BRANDS_002", "Invalid brands parameters."),
    GENERIC_BRAND_ERROR("ERR_BRAND_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    BrandsErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
