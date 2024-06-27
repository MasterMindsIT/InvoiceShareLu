package com.invoice.companies.services;

import com.invoice.companies.CompanyDTO;
import com.invoice.companies.CompanyExternalAPI;
import com.invoice.companies.mappers.CompanyMapper;
import com.invoice.companies.models.Company;
import com.invoice.companies.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CompanyService implements CompanyExternalAPI {
    private CompanyRepository companyRepository;
    private CompanyMapper companyMapper;

    @Override
    public CompanyDTO getCompanyById(Long id) {
        return companyMapper.companyToCompanyDTO(companyRepository.findById(id).orElseThrow(()-> new NoSuchElementException("")));
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(company -> companyMapper.companyToCompanyDTO(company))
                .toList();
    }

    @Transactional
    @Override
    public CompanyDTO saveCompany(CompanyDTO companyDTO) {
        return companyMapper.companyToCompanyDTO(companyRepository.save(companyMapper.companyDTOToCompany(companyDTO)));
    }
    @Transactional
    @Override
    public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
        Company company = companyMapper.companyDTOToCompany(getCompanyById(id));
        company.setName(companyDTO.name());
        company.setCategory(companyDTO.category());
        company.setRut(companyDTO.rut());
        company.setUser_id(companyDTO.user_id());
        company.setTaxes_id(companyDTO.taxes_id());
        return companyMapper.companyToCompanyDTO(companyRepository.save(company));
    }
    @Transactional
    @Override
    public CompanyDTO deleteCompany(Long id) {
        Company company = companyMapper.companyDTOToCompany(getCompanyById(id));
        CompanyDTO companyDTO = companyMapper.companyToCompanyDTO(company);
        companyRepository.delete(company);
        return companyDTO;
    }
}