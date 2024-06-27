package com.invoice.discount.exceptions;

import lombok.Getter;

@Getter
public enum DiscountErrorCatalog {
    DISCOUNT_NOT_FOUND("ERR_DISCOUNT_001", "Discount not found."),
    INVALID_DISCOUNT("ERR_DISCOUNT_002", "Invalid Discounts parameters."),
    GENERIC_DISCOUNT_ERROR("ERR_DISCOUNT_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    DiscountErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
