package com.trilok.productservice.controllers;

import com.trilok.productservice.exceptions.NotFoundException;
import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;
import com.trilok.productservice.services.CategoryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@RestController
@RequestMapping("/products/category")

public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<String >> getAllCategories(){
        ResponseEntity response = new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);

        return response;
    }

   @GetMapping("/{categoryId}")
    public ResponseEntity<List<Product>> getProductsInCategory(@PathVariable("categoryId") String categoryId)
           throws NotFoundException {
       Optional<List<Product>> productList = categoryService.getProductsInCategory(categoryId);
       if(productList.isEmpty()){
           throw new NotFoundException("Category not found " + categoryId);
       }
        ResponseEntity response = new ResponseEntity<>(categoryService.getProductsInCategory(categoryId).get(),
                                                    HttpStatus.OK);
        return response;
    }


}
