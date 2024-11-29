package com.example.pocJop.Dto.categoryDtos;

import com.example.pocJop.Dto.UnidirectionalMapper;
import com.example.pocJop.Models.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryDtoMapper implements UnidirectionalMapper<CategoryDto, Category> {
    @Override
    public CategoryDto from(Category input) {
        return CategoryDto.builder()
                .id(input.getId())
                .name(input.getName())
                .build();
    }
}
