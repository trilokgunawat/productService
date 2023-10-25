
package com.trilok.productservice.services;

import com.trilok.productservice.clients.FakeStoreProductClient;
import com.trilok.productservice.clients.FakeStoreProductDto;
import com.trilok.productservice.dtos.ProductDto;
import com.trilok.productservice.exceptions.NotFoundException;
import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FakeStoreProductServiceImpl implements ProductService {
    private FakeStoreProductClient fakeStoreClient;

    public FakeStoreProductServiceImpl( FakeStoreProductClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
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
    public List<Product> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProducts();

        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDto productDto : fakeStoreProductDtos){
            answer.add(convertFakeStoreProductDtoToProduct(productDto));
        }
        return answer;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
//
        Optional<FakeStoreProductDto> fakeStoreProductDto = fakeStoreClient.getSingleProduct(productId);
        if (fakeStoreProductDto.isPresent()) {
            return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto.get()));
        }
        return Optional.empty();
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
        FakeStoreProductDto productDto1 = fakeStoreClient.addNewProduct(productDto);
        return convertFakeStoreProductDtoToProduct(productDto1);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {

        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.updateProduct(productId, productDto );
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Boolean deleteProduct(Long productId) {

        return null;
    }

}
