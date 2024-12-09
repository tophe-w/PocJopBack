package com.example.pocJop.Services;

import java.util.List;
import java.util.Optional;


import com.example.pocJop.Dto.categoryDtos.CategoryDto;
import com.example.pocJop.Dto.categoryDtos.CategoryDtoMapper;
import com.example.pocJop.helper.Helpers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.pocJop.Models.Category;
import com.example.pocJop.Repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryDtoMapper categoryDtoMapper;


    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new RuntimeException("There is no category");
        }
        return categories.stream()
                .map(categoryDtoMapper::from)
                .toList();
    }
    
    public Optional<CategoryDto> getCategoryById(Long id) {
        return categoryRepository.findById(id).map(categoryDtoMapper::from);
    }
    
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public CategoryDto updateCategory(Long id, Category category) {

        Category categoryToUpdate = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La categorie avec l'Id n°" + id + " n'est pas trouvée"));

        Helpers.UpdateObjectFields(category, categoryToUpdate);

        categoryRepository.save(categoryToUpdate);
        return categoryDtoMapper.from(categoryToUpdate);

    }

    
}
