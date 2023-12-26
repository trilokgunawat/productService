package com.trilok.productservice.services;

import com.trilok.productservice.clients.FakeStoreCategoryClient;
import com.trilok.productservice.clients.FakeStoreProductDto;
import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    FakeStoreCategoryClient fakeStoreCategoryClient;

    public FakeStoreCategoryServiceImpl(FakeStoreCategoryClient fakeStoreCategoryClient) {
        this.fakeStoreCategoryClient = fakeStoreCategoryClient;
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());

        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);

        product.setImageUrl(productDto.getImage());
        return product;
    }

    @Override
    public List<Category> getAllCategories() {
        List<String> response = fakeStoreCategoryClient.getAllCategories();
        List<Category> answer = new ArrayList<>();
        for(String r : response){
            Category category = new Category();
            category.setName(r);
            answer.add(category);
        }
        return answer;
    }

    @Override
    public List<Product> getProductsInCategory(String categoryName) {
        List<FakeStoreProductDto> response =  fakeStoreCategoryClient.getProductsInCategory(categoryName);

        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDto f : response){
            answer.add(convertFakeStoreProductDtoToProduct(f));
        }
        return answer;
    }
}
