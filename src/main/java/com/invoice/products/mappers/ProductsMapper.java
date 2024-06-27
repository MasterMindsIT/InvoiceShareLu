package com.invoice.products.mappers;

import com.invoice.products.ProductsDTO;
import com.invoice.products.models.Products;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductsMapper {
    ProductsMapper INSTANCE = Mappers.getMapper(ProductsMapper.class);
    ProductsDTO productToProductsDTO(Products products);
    Products ProductsDTOToProducts(ProductsDTO productsDTO);
}
