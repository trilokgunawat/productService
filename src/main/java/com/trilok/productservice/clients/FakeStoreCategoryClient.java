package com.trilok.productservice.clients;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreCategoryClient {
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCategoryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public List<String> getAllCategories(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String[].class);
        return Arrays.asList(response.getBody());
    }

    public Optional<List<FakeStoreProductDto>> getProductsInCategory(String categoryName){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =  restTemplate.getForEntity(
                                "https://fakestoreapi.com/products/category/{category_name}",
                                    FakeStoreProductDto[].class, categoryName);
        return Optional.ofNullable(Arrays.asList(response.getBody()));

    }

}
