package com.invoice.gateway;

import com.invoice.brands.BrandDTO;
import com.invoice.brands.BrandExternalAPI;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/brands")
public class BrandsController {

    private final BrandExternalAPI brandExternalAPI;

    public BrandsController(BrandExternalAPI brandExternalAPI) {
        this.brandExternalAPI = brandExternalAPI;
    }

    @GetMapping("/{id}")
    public BrandDTO findById(@PathVariable("id") Long id){
        System.out.println("ControllerBrand");
        return brandExternalAPI.getBrandById(id);
    }
    @GetMapping
    public List<BrandDTO> all(){
        return brandExternalAPI.getAllBrands();
    }
    @PostMapping
    public BrandDTO save(@RequestBody @Valid BrandDTO brandDTO){
        return brandExternalAPI.saveBrand(brandDTO);
    }
    @PutMapping("{id}")
    public BrandDTO update(@PathVariable("id") Long id, @RequestBody  BrandDTO brandDTO){
        return brandExternalAPI.updateBrand(id, brandDTO);
    }
    @DeleteMapping("{id}")
    public BrandDTO delete(@PathVariable("id") Long id){
        return brandExternalAPI.deleteBrand(id);
    }
}
