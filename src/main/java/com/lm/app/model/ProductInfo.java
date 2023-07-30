package com.lm.app.model;

import com.lm.app.entity.Product;

// Class representing a product's information
public class ProductInfo {
    // Product code
    private String code;

    // Product name
    private String name;

    // Product price
    private double price;

    // Default constructor
    public ProductInfo() {
    }

    // Constructor for creating a ProductInfo object from a Product entity
    public ProductInfo(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    // Constructor for creating a ProductInfo object with given code, name and price
    // Mostly used in JPA/Hibernate query
    public ProductInfo(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // Getter for Product Code
    public String getCode() {
        return code;
    }

    // Setter for Product Code
    public void setCode(String code) {
        this.code = code;
    }

    // Getter for Product Name
    public String getName() {
        return name;
    }

    // Setter for Product Name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for Product Price
    public double getPrice() {
        return price;
    }

    // Setter for Product Price
    public void setPrice(double price) {
        this.price = price;
    }

}
