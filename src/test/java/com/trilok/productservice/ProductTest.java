package com.trilok.productservice;

import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;
import com.trilok.productservice.repositories.CategoryRepository;
import com.trilok.productservice.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    void savingProductsAndCategory(){

//        Category category = new Category();
//        category.setName("phones");
////        Category savedCategory = categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setPrice(100);
//        product.setImageUrl("hello");
//        product.setCategory(category);
////        productRepository.save(product);
//        Category category = new Category();
//        category.setName("electronics");
////        Category savedCategory = categoryRepository.save(category);
//
////        System.out.println(category);
//        Product product = new Product();
//        product.setPrice(101);
//        product.setImageUrl("hiiiii");
////        product.setCategory(category);
//        productRepository.save(product);
//
//        Product p1 = new Product();
//        p1.setPrice(12);
//        p1.setCategory(category);
//        Product p2 = new Product();
//        p2.setCategory(category);
//        p2.setPrice(13);
//        category.setProducts(Arrays.asList(p1, p2));
//        categoryRepository.save(category);
    }
//    @Test
//    @Transactional
//    void fetchTypesTest(){
//        Product product = productRepository.findProductById(52L);
//
//        System.out.println("FetchedProduct");
//
////        product.getCategory();
//    }
    @Test
    @Transactional
    @Rollback(value = false)
    void saveProductsFromCategory(){
        Category category = categoryRepository.findById(202L).get();

        Product product = new Product();
        product.setPrice(1012);
        product.setImageUrl("new image");
        product.setCategory(category);
        productRepository.save(product);

        product = new Product();
        product.setPrice(1013);
        product.setImageUrl("new new image");
        product.setCategory(category);
        productRepository.save(product);

    }
//
//    }
}
