package com.duongvb.SecuritySystem.controller;

import com.duongvb.SecuritySystem.dto.request.ProductCreateRequest;
import com.duongvb.SecuritySystem.entity.Product;
import com.duongvb.SecuritySystem.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody ProductCreateRequest request) {
        System.out.println(request);
        return productService.createProduct(request);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/{productId}")
    public Product findProductById(@PathVariable("productId") String productId) {
        return productService.findProductById(productId);
    }

    @PatchMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") String productId, @RequestBody ProductCreateRequest request) {
        return productService.updateProduct(productId, request);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId) {
        return productService.deleteProduct(productId);
    }
}
