package com.duongvb.SecuritySystem.dto.request;

import java.math.BigDecimal;

public class ProductCreateRequest {
    private String productName;
    private BigDecimal productPrice;
    private String productDesc;

    @Override
    public String toString() {
        return "ProductCreateRequest{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
