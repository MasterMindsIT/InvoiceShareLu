package com.invoice.categories.services;

import com.invoice.categories.CategoryDTO;
import com.invoice.categories.CategoryExternalAPI;
import com.invoice.categories.mappers.CategoryMapper;
import com.invoice.categories.models.Category;
import com.invoice.categories.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import com.invoice.categories.exceptions.CategoryNotFoundException;

@Service
@AllArgsConstructor
public class CategoryService implements CategoryExternalAPI {
    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDTO getCategoryyId(Long id) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new));
    }

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> categoryMapper.categoryToCategoryDTO(category))
                .toList();
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.save(categoryMapper.categoryDTOToCategory(categoryDTO)));
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryMapper.categoryDTOToCategory(getCategoryyId(id));
        category.setName(categoryDTO.name());
        category.setDescription(categoryDTO.description());
        return categoryMapper.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO deleteCategory(Long id) {
        Category category = categoryMapper.categoryDTOToCategory(getCategoryyId(id));
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        categoryRepository.delete(category);
        return categoryDTO;
    }
}
