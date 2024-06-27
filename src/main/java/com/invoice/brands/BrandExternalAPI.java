package com.invoice.brands;



import com.invoice.brands.BrandDTO;

import java.util.List;

public interface BrandExternalAPI {
    BrandDTO getBrandById(Long id);
    List<BrandDTO> getAllBrands();
    BrandDTO saveBrand(BrandDTO brandDTO);

    BrandDTO updateBrand(Long id, BrandDTO brandDTO);

    BrandDTO deleteBrand(Long id);
}
