package com.invoice.companies.exceptions;

import lombok.Getter;

@Getter
public enum CompanyErrorCatalog {
    COMPANY_NOT_FOUND("ERR_COMPANY_001", "Company not found."),
    INVALID_COMPANY("ERR_COMPANY_002", "Invalid Companies parameters."),
    GENERIC_COMPANY_ERROR("ERR_COMPANY_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    CompanyErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}