package com.trilok.productservice.services;

import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;
import com.trilok.productservice.repositories.CategoryRepository;
import com.trilok.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class SelfCategoryService implements CategoryService{
    CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public SelfCategoryService(CategoryRepository categoryRepository,
                               ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public Optional<List<Product>> getProductsInCategory(String categoryId) {

        return Optional.ofNullable(productRepository.findProductsByCategory_Name(categoryId));
    }
}
