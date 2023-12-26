
package com.trilok.productservice.services;

import com.trilok.productservice.clients.FakeStoreProductClient;
import com.trilok.productservice.clients.FakeStoreProductDto;
import com.trilok.productservice.dtos.ProductDto;
import com.trilok.productservice.exceptions.NotFoundException;
import com.trilok.productservice.models.Category;
import com.trilok.productservice.models.Product;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("fakeProductService")
public class FakeStoreProductServiceImpl implements ProductService {
    private FakeStoreProductClient fakeStoreClient;
    private Map<Long,Object> fakeStoreProducts = new HashMap<>();
    private RedisTemplate<Long, Object>  redisTemplate;

    public FakeStoreProductServiceImpl(FakeStoreProductClient fakeStoreClient, RedisTemplate<Long,Object> redisTemplate) {
        this.fakeStoreClient = fakeStoreClient;
        this.redisTemplate = redisTemplate;
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
    public Optional<Product> getSingleProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto = (FakeStoreProductDto) redisTemplate
                                                    .opsForHash()
                                                    .get(productId,"PRODUCTS");
        if(fakeStoreProductDto!=null){
            return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
//        if(fakeStoreProducts.containsKey(productId)){
//            return Optional.of(convertFakeStoreProductDtoToProduct((FakeStoreProductDto) fakeStoreProducts.get(productId)));
//        }
        Optional<FakeStoreProductDto> fakeStoreProductDtoOptional = fakeStoreClient.getSingleProduct(productId);

        if (fakeStoreProductDtoOptional.isPresent()) {
            redisTemplate.opsForHash().put(productId, "PRODUCTS", fakeStoreProductDtoOptional.get());
//            fakeStoreProducts.put(productId,fakeStoreProductDtoOptional.get());
            return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDtoOptional.get()));
        }
        return Optional.empty();
    }

    @Override
    public Product addNewProduct(ProductDto productDto) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.addNewProduct(productDto);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {

        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.updateProduct(productId, productDto );

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Optional<Product> deleteProduct(Long productId) {
        Optional<FakeStoreProductDto> fakeStoreProductDto = fakeStoreClient.deleteProduct(productId);
        if(fakeStoreProductDto.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(convertFakeStoreProductDtoToProduct(fakeStoreProductDto.get()));
    }

}
