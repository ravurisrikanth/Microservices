package com.srikanth.controller;

import com.srikanth.dto.ProductRequest;
import com.srikanth.model.Product;
import com.srikanth.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
//    @PostMapping
    @RequestMapping(path = "api/product",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return "Product added Successfully Created";

    }

}
