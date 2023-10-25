package com.trilok.productservice.services;

import com.trilok.productservice.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<String> getAllCategories();

    Optional<List<Product>> getProductsInCategory(@PathVariable("categoryId") String categoryId);
}
