package com.example.cakedog;

public class Product {

    private Long productId;
    private String productType;
    private String productName;
    private Double productPrice;

    private String productObservation;

    public Product(Long productId, String productType, String productName, Double productPrice) {
        this.productId = productId;
        this.productType = productType;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductObservation() {
        return productObservation;
    }

    public void setProductObservation(String productObservation) {
        this.productObservation = productObservation;
    }

}
