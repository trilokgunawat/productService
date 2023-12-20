package com.trilok.productservice.controllers;

import com.trilok.productservice.clients.authenticationClient.AuthenticationClient;
import com.trilok.productservice.clients.authenticationClient.dtos.Role;
import com.trilok.productservice.clients.authenticationClient.dtos.SessionStatus;
import com.trilok.productservice.clients.authenticationClient.dtos.ValidateTokenResponseDto;
import com.trilok.productservice.dtos.ErrorResponseDto;
import com.trilok.productservice.dtos.ProductDto;
import com.trilok.productservice.exceptions.NotFoundException;
import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;
import com.trilok.productservice.repositories.ProductRepository;
import com.trilok.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private ProductRepository productRepository;
    private AuthenticationClient authenticationClient;

    public ProductController(@Qualifier("fakeProductService") ProductService productService,
                             ProductRepository productRepository,
                             AuthenticationClient authenticationClient) {

        this.productService = productService;
        this.productRepository = productRepository;
        this.authenticationClient = authenticationClient;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(@Nullable @RequestHeader("AUTH_TOKEN") String token,
                                                        @Nullable @RequestHeader("USER_ID") Long userId){
        // check if token exists
//        if (token == null || userId == null){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//
//        ValidateTokenResponseDto response = authenticationClient.validate(token, userId);
//
//        //check if token is valid
//        if(response.getSessionStatus().equals(SessionStatus.INVALID)){
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//        //validate the token
//        //RestTemplate rt = new RestTemplate();
//        //rt.get("localhost:8080/auth/validate);
//
//        //check if user has permissions
//
//        boolean isUserAdmin = false;
//        for(Role role: response.getUserDto().getRoles()){
//            if(role.getName().equals("ADMIN")){
//                isUserAdmin = true;
//            }
//            if(!isUserAdmin){
//                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//            }
//        }
        List<Product> products = productService.getAllProducts();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("auth_token", "noaccess4uheyhey");
        Optional<Product> productOptional = productService.getSingleProduct(productId);
        if(productOptional.isEmpty()){
            throw new NotFoundException("No product with product id; " + productId);
        }
        ResponseEntity<Product> response = new ResponseEntity<>(
                                                        productService.getSingleProduct(productId).get(),
                                                        headers,
                                                        HttpStatus.NOT_FOUND
                                                        );
        return response;
    }
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){

//        Product newProduct = productService.addNewProduct(productDto);
        Product newProduct = new Product();
        newProduct.setDescription(productDto.getDescription());
        newProduct.setTitle(productDto.getTitle());
        newProduct.setImageUrl(productDto.getImage());
        newProduct.setPrice(productDto.getPrice());

       productRepository.save(newProduct);

        ResponseEntity<Product> response = new ResponseEntity<>(newProduct,
                                                                HttpStatus.OK);


        return response;
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto){
//
        Product product =  productService.updateProduct(productId, productDto);
        ResponseEntity<Product> response = new ResponseEntity<>(product, HttpStatus.OK);
        return response;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "delete product" + productId;
    }
}
