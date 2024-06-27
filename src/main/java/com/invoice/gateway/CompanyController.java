package com.invoice.gateway;

import com.invoice.companies.CompanyDTO;
import com.invoice.companies.CompanyExternalAPI;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies")
public class CompanyController {
    private CompanyExternalAPI companyExternalAPI;

    public CompanyController(CompanyExternalAPI companyExternalAPI) {
        this.companyExternalAPI = companyExternalAPI;
    }
    @GetMapping("/{id}")
    public CompanyDTO findById(@PathVariable("id")Long id){
        return companyExternalAPI.getCompanyById(id);
    }
    @GetMapping
    public List<CompanyDTO> all(){
        return companyExternalAPI.getAllCompanies();
    }
    @PostMapping
    public CompanyDTO save(@RequestBody @Valid CompanyDTO companyDTO){
        return companyExternalAPI.saveCompany(companyDTO);
    }
    @PutMapping("/{id}")
    public CompanyDTO update(@PathVariable("id") Long id, CompanyDTO companyDTO){
        return companyExternalAPI.updateCompany(id, companyDTO);
    }
    @DeleteMapping("/{id}")
    public CompanyDTO delete(@PathVariable("id") Long id){
        return companyExternalAPI.deleteCompany(id);
    }
}