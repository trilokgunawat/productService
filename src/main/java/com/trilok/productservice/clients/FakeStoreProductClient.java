package com.trilok.productservice.clients;

import com.trilok.productservice.dtos.ProductDto;
import com.trilok.productservice.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreProductClient {
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables)
            throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return   restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public List<FakeStoreProductDto> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l = restTemplate.getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);

        return Arrays.asList(l.getBody());
    };

    public Optional<FakeStoreProductDto> getSingleProduct(Long productId) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =  restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",
                FakeStoreProductDto.class,
                productId);
        FakeStoreProductDto productDto = response.getBody();
        return Optional.ofNullable(productDto);
    };

    public FakeStoreProductDto addNewProduct(ProductDto productDto){

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =  restTemplate.postForEntity("https://fakestoreapi.com/products",
                productDto,
                FakeStoreProductDto.class);
        return response.getBody();
    };

    public FakeStoreProductDto updateProduct(Long productId, ProductDto productDto){
        ResponseEntity<FakeStoreProductDto> response = requestForEntity (HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                productDto,
                FakeStoreProductDto.class,
                productId);
        return response.getBody();
    };

    public FakeStoreProductDto deleteProduct(Long productId){
        ResponseEntity<FakeStoreProductDto> response = requestForEntity(HttpMethod.DELETE,
                                                                "https://fakestoreapi.com/products/6",
                                                                    null,
                                                                    FakeStoreProductDto.class,
                                                                    productId);
        return response.getBody();
    };


}
