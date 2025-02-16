package com.duongvb.SecuritySystem.service;

import com.duongvb.SecuritySystem.dto.request.ProductCreateRequest;
import com.duongvb.SecuritySystem.entity.Product;
import com.duongvb.SecuritySystem.repository.ProductRepository;
import com.duongvb.SecuritySystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    public Product createProduct(ProductCreateRequest request) {
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductDesc(request.getProductDesc());
        product.setProductPrice(request.getProductPrice());

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
