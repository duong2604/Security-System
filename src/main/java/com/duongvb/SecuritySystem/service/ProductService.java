package com.duongvb.SecuritySystem.service;

import com.duongvb.SecuritySystem.dto.request.ProductCreateRequest;
import com.duongvb.SecuritySystem.entity.Product;
import com.duongvb.SecuritySystem.mapper.ProductMapper;
import com.duongvb.SecuritySystem.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;


    public Product createProduct(ProductCreateRequest request) {
        Product product = productMapper.toProduct(request);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(String productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(String productId, ProductCreateRequest request) {
        Product product = findProductById(productId);
        productMapper.updateProduct(product, request);
        return productRepository.save(product);
    }

    public String deleteProduct(String productId) {
        productRepository.deleteById(productId);

        return "Product deleted successfully";
    }
}
