package com.invoice.brands.services;

import com.invoice.brands.BrandDTO;
import com.invoice.brands.BrandExternalAPI;
import com.invoice.brands.exceptions.BrandNotFounfException;
import com.invoice.brands.mappers.BrandMapper;
import com.invoice.brands.models.Brand;
import com.invoice.brands.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandService implements BrandExternalAPI {

    private BrandRepository brandRepository;


    private BrandMapper brandMapper;

    @Override
    public BrandDTO getBrandById(Long id) {
        return brandMapper.brandToBrandDTO(brandRepository.findById(id).orElseThrow(BrandNotFounfException::new));
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brand -> brandMapper.brandToBrandDTO(brand))
                .toList();
    }

    @Override
    public BrandDTO saveBrand(BrandDTO brandDTO) {
        return brandMapper.brandToBrandDTO(brandRepository.save(brandMapper.brandDTOToBrand(brandDTO)));
    }

    @Override
    public BrandDTO updateBrand(Long id, BrandDTO brandDTO) {
        Brand brand = brandMapper.brandDTOToBrand(getBrandById(id));
        brand.setName(brandDTO.name());
        brand.setDescription(brandDTO.description());
        return brandMapper.brandToBrandDTO(brandRepository.save(brand));
    }

    @Override
    public BrandDTO deleteBrand(Long id) {
        Brand brand = brandMapper.brandDTOToBrand(getBrandById(id));
        BrandDTO brandDTO = brandMapper.brandToBrandDTO(brand);
        brandRepository.delete(brand);
        return brandDTO;
    }
}
