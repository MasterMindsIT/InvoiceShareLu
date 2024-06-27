package com.invoice.providers.exceptions;

import lombok.Getter;

@Getter
public enum ProviderErrorCatalog {
    PROVIDER_NOT_FOUND("ERR_PROVIDER_001", "Provider not found."),
    INVALID_PROVIDER("ERR_PROVIDER_002", "Invalid Provider parameters."),
    GENERIC_PROVIDER_ERROR("ERR_PROVIDER_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    ProviderErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
