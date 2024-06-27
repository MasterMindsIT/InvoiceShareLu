package com.invoice.products.services;

import com.invoice.products.ProductsDTO;
import com.invoice.products.ProductsExternalAPI;
import com.invoice.products.exceptions.ProductNotFoundException;
import com.invoice.products.mappers.ProductsMapper;
import com.invoice.products.models.Products;
import com.invoice.products.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductsService implements ProductsExternalAPI {
    private ProductsRepository productsRepository;
    private ProductsMapper productsMapper;
    @Override
    public ProductsDTO getProductById(Long id) {
        return productsMapper.productToProductsDTO(productsRepository.findById(id).orElseThrow(ProductNotFoundException::new));
    }

    @Override
    public List<ProductsDTO> getAllProducts() {
        return productsRepository.findAll()
                .stream()
                .map(products -> productsMapper.productToProductsDTO(products))
                .toList();
    }

    @Override
    public ProductsDTO saveProduct(ProductsDTO productsDTO) {
        return productsMapper.productToProductsDTO(productsRepository.save(productsMapper.ProductsDTOToProducts(productsDTO)));
    }

    @Override
    public ProductsDTO updateProduct(Long id, ProductsDTO productsDTO) {
        Products products = productsMapper.ProductsDTOToProducts(getProductById(id));
        products.setName(productsDTO.name());
        products.setDescription(productsDTO.description());
        products.setPrice(productsDTO.price());
        products.setBrandId(productsDTO.brandId());
        products.setCategoryId(productsDTO.categoryId());
        products.setProviderId(productsDTO.providerId());
        productsRepository.save(products);
        return productsMapper.productToProductsDTO(products);
    }

    @Override
    public ProductsDTO deleteProduct(Long id) {
        Products products = productsMapper.ProductsDTOToProducts(getProductById(id));
        ProductsDTO productsDTO = productsMapper.productToProductsDTO(products);
        productsRepository.delete(products);
        return productsDTO;
    }
}
