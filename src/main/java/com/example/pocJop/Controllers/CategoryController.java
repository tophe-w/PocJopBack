package com.example.pocJop.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocJop.Models.Category;
import com.example.pocJop.Models.Gare;
import com.example.pocJop.Services.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("get/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

}
