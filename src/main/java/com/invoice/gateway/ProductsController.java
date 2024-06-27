package com.invoice.gateway;

import com.invoice.products.ProductsDTO;
import com.invoice.products.ProductsExternalAPI;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    private final ProductsExternalAPI productsExternalAPI;

    public ProductsController(ProductsExternalAPI productsExternalAPI) {
        this.productsExternalAPI = productsExternalAPI;
    }
    @GetMapping("/{id}")
    public ProductsDTO getProductByI(@PathVariable("id") Long id){
        return productsExternalAPI.getProductById(id);
    }
    @GetMapping
    public List<ProductsDTO> all(){
        return productsExternalAPI.getAllProducts();
    }
    @PostMapping
    public ProductsDTO save(@RequestBody ProductsDTO productsDTO){
        return productsExternalAPI.saveProduct(productsDTO);
    }
    @PutMapping("/{id}")
    public ProductsDTO update(@PathVariable("id") Long id, ProductsDTO productsDTO){
        return productsExternalAPI.updateProduct(id, productsDTO);
    }
    @DeleteMapping("/{id}")
    public ProductsDTO delete(@PathVariable("id") Long id){
        return productsExternalAPI.deleteProduct(id);
    }
}
