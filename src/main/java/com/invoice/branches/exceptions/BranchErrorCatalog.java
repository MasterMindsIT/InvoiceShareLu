package com.invoice.branches.exceptions;

import lombok.Getter;

@Getter
public enum BranchErrorCatalog {
    BRANCH_NOT_FOUND("ERR_BRANCH_001", "Branch not found."),
    INVALID_BRANCH("ERR_BRANCH_002", "Invalid Branches parameters."),
    GENERIC_BRANCH_ERROR("ERR_BRANCH_GENERIC_001", "An unexpected error occurred.");

    private final String code;
    private final String message;
    BranchErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}