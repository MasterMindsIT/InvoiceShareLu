package com.invoice.categories.exceptions;

import lombok.Getter;

@Getter
public enum CategoryErrorCatalog {
    CATEGORY_NOT_FOUND("ERR_CATEGORY_001", "Category not found."),
    INVALID_CATEGORY("ERR_CATEGORY_002", "Invalid Categories parameters."),
    GENERIC_CATEGORY_ERROR("ERR_CATEGORY_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    CategoryErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
