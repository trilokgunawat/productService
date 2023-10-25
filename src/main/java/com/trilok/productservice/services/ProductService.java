package com.trilok.productservice.services;

import com.trilok.productservice.dtos.ProductDto;
import com.trilok.productservice.exceptions.NotFoundException;
import com.trilok.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getSingleProduct(Long productId) throws NotFoundException;

    Product addNewProduct(ProductDto product);

    Product updateProduct(Long productId, ProductDto productDto);

    Boolean deleteProduct(Long productId);
}
