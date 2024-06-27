package com.invoice.branches;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.invoice.branches.validations.anotations.*;
import jakarta.validation.constraints.Email;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BranchDTO (
        Long id,
        Long company_id,
        @ValidNameBranch String name,
        @ValidAddresBranch String address,
        @ValidDescriptionBranch String description,
        @ValidEmailBranch String email,
        @ValidPhoneBranch String phone
){
}