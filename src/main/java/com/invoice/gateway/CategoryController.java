package com.invoice.gateway;

import com.invoice.categories.CategoryDTO;
import com.invoice.categories.CategoryExternalAPI;
import com.invoice.categories.exceptions.CategoryNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private CategoryExternalAPI categoryExternalAPI;

    public CategoryController(CategoryExternalAPI categoryExternalAPI) {
        this.categoryExternalAPI = categoryExternalAPI;
    }
    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable("id")Long id){

        return categoryExternalAPI.getCategoryyId(id);

    }
    @GetMapping
    public List<CategoryDTO> all(){
        return categoryExternalAPI.getAllCategory();
    }
    @PostMapping
    public CategoryDTO save(@RequestBody @Valid CategoryDTO categoryDTO){
        return categoryExternalAPI.saveCategory(categoryDTO);
    }
    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable("id") Long id, CategoryDTO categoryDTO){
        return categoryExternalAPI.updateCategory(id, categoryDTO);
    }
    @DeleteMapping("/{id}")
    public CategoryDTO delete(@PathVariable("id") Long id){
        return categoryExternalAPI.deleteCategory(id);
    }
}
