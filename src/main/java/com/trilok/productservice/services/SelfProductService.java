package com.trilok.productservice.services;

import com.trilok.productservice.dtos.ProductDto;
import com.trilok.productservice.exceptions.NotFoundException;
import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;
import com.trilok.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("selfProductService")
public class SelfProductService implements ProductService{
    ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
        Product product = productRepository.findProductById(productId);
        if(product == null ){
            throw new NotFoundException("Product Not Exist");
        }
        return Optional.of(product);
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());

        product.setTitle(productDto.getTitle());
        product.setImageUrl(productDto.getImage());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);


        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {
        Product product = new Product();
        product.setPrice(productDto.getPrice());
        product.setId(productId);
        product.setTitle(productDto.getTitle());
        product.setImageUrl(productDto.getImage());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Optional<Product> deleteProduct(Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        return product;
    }
}
