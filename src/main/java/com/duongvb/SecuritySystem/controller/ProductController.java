package com.duongvb.SecuritySystem.controller;

import com.duongvb.SecuritySystem.dto.request.ProductCreateRequest;
import com.duongvb.SecuritySystem.entity.Product;
import com.duongvb.SecuritySystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody ProductCreateRequest request) {
        System.out.println(request);
        return productService.createProduct(request);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
