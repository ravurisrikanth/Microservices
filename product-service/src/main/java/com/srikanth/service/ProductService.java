package com.srikanth.service;

import com.srikanth.dto.ProductDisplay;
import com.srikanth.dto.ProductRequest;
import com.srikanth.model.Product;
import com.srikanth.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is create",product.getId());

    }


    public List<ProductDisplay> getAllProduct() {
        List<Product> products=productRepository.findAll();
        return products.stream().map(product -> mapToProductDisplay(product)).toList();
    }

    private ProductDisplay mapToProductDisplay(Product product) {
        return ProductDisplay.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }


}
