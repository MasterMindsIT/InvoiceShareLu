package com.invoice.brands.mappers;

import com.invoice.brands.BrandDTO;
import com.invoice.brands.models.Brand;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    BrandDTO brandToBrandDTO(Brand brand);

    Brand brandDTOToBrand(BrandDTO brandDTO);
}
