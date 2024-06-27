package com.invoice.taxes.exceptions;

import lombok.Getter;

@Getter
public enum TaxesErrorCatalog {
    TAXES_NOT_FOUND("ERR_TAXES_001", "Taxes not found."),
    INVALID_TAXES("ERR_TAXES_002", "Invalid Taxes parameters."),
    GENERIC_TAXES_ERROR("ERR_TAXES_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    TaxesErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
