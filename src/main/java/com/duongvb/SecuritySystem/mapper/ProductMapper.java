package com.duongvb.SecuritySystem.mapper;

import com.duongvb.SecuritySystem.dto.request.ProductCreateRequest;
import com.duongvb.SecuritySystem.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductCreateRequest request);

    Product updateProduct(@MappingTarget Product product, ProductCreateRequest request);

}
