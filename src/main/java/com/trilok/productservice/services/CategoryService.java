package com.trilok.productservice.services;

import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategories();

    List<Product> getProductsInCategory(@PathVariable("categoryId") String categoryId);
}
