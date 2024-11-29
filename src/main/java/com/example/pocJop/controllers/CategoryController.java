package com.example.pocJop.controllers;

import java.util.List;
import java.util.Optional;

import com.example.pocJop.Dto.categoryDtos.CategoryDto;
import com.example.pocJop.exceptions.customException.ResourceNotFoundException;
import com.example.pocJop.helper.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pocJop.Models.Category;
import com.example.pocJop.Services.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final static String CATEGORY_BASE_PATH = "/category";
    private final static String ENDPOINT_CATEGORY_GET_ALL = CATEGORY_BASE_PATH + "/get/all";
    private final static String ENDPOINT_CATEGORY_GET_BY_ID = CATEGORY_BASE_PATH + "/get/{id}";
    private final static String ENDPOINT_CATEGORY_CREATE = CATEGORY_BASE_PATH + "/create";
    private final static String ENDPOINT_CATEGORY_UPDATE = CATEGORY_BASE_PATH + "/update/{id}";

    private final CategoryService categoryService;

    @Autowired
    private Messages msg;

    @GetMapping(ENDPOINT_CATEGORY_GET_ALL)
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping(ENDPOINT_CATEGORY_GET_BY_ID)
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        Optional<CategoryDto> categoryDto= categoryService.getCategoryById(id);
        return categoryDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseThrow(() -> new ResourceNotFoundException(msg.getMessage("error_msg.category_not_found", Long.toString(id))));
    }

    @PostMapping(ENDPOINT_CATEGORY_CREATE)
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @PatchMapping(ENDPOINT_CATEGORY_UPDATE)
    public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody Category category) {
        return new ResponseEntity<>(categoryService.updateCategory(id, category), HttpStatus.OK);
    }

}
