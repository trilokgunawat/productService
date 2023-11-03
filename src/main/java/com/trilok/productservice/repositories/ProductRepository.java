package com.trilok.productservice.repositories;

import com.trilok.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);

    List<Product> findAll();
    Product findProductById(Long id);

    List<Product> findProductsByCategory_Name(String name);
    Product findProductByIdEquals(Long id);


    Product findProductByPriceBetween(double greaterThanEqualPrice,
                                      double lessThanEqualPrice);




}
