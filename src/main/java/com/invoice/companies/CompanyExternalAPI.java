package com.invoice.companies;

import java.util.List;

public interface CompanyExternalAPI {
    CompanyDTO getCompanyById(Long id);
    List<CompanyDTO> getAllCompanies();
    CompanyDTO saveCompany(CompanyDTO companyDTO);
    CompanyDTO updateCompany(Long id, CompanyDTO companyDTO);
    CompanyDTO deleteCompany(Long id);
}