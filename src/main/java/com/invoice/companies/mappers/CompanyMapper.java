package com.invoice.companies.mappers;

import com.invoice.companies.CompanyDTO;
import com.invoice.companies.models.Company;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
    CompanyDTO companyToCompanyDTO(Company company);
    Company companyDTOToCompany(CompanyDTO companyDTO);
}