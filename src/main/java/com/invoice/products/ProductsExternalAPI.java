package com.invoice.products;


import java.util.List;

public interface ProductsExternalAPI {
    ProductsDTO getProductById(Long id);
    List<ProductsDTO> getAllProducts();
    ProductsDTO saveProduct(ProductsDTO productsDTO);

    ProductsDTO updateProduct(Long id, ProductsDTO productsDTO);

    ProductsDTO deleteProduct(Long id);

}
