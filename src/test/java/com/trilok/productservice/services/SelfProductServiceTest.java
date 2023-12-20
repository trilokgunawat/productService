package com.trilok.productservice.services;

import com.trilok.productservice.controllers.ProductController;
import com.trilok.productservice.exceptions.NotFoundException;
import com.trilok.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class SelfProductServiceTest {
    @MockBean
    ProductRepository productRepository;
    @Autowired
    SelfProductService productService;


    @Test
    void testGetSingleProductThrowsExceptoinWhenNoSuchProduct(){
        when(productRepository.findProductById(any())).thenReturn(null);

        assertThrows(NotFoundException.class,()-> productService.getSingleProduct(1l));


    }

}