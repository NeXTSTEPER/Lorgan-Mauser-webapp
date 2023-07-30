package com.lm.app.model;

// Class representing detailed information of an order
public class OrderDetailInfo {
    // Order ID
    private String id;
 
    // Product Code related to the order
    private String productCode;

    // Product Name related to the order
    private String productName;
 
    // Quantity of the product ordered
    private int quanity;

    // Price per unit of the product ordered
    private double price;

    // Total amount for the product ordered
    private double amount;

    // Default constructor
    public OrderDetailInfo() {
    }
 
    // Constructor for creating an OrderDetailInfo object with all necessary details.
    // Mostly used for JPA/Hibernate Query.
    public OrderDetailInfo(String id, String productCode, String productName, 
                           int quanity, double price, double amount) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.quanity = quanity;
        this.price = price;
        this.amount = amount;
    }
 
    // Getter for Order ID
    public String getId() {
        return id;
    }
 
    // Setter for Order ID
    public void setId(String id) {
        this.id = id;
    }
 
    // Getter for Product Code
    public String getProductCode() {
        return productCode;
    }
 
    // Setter for Product Code
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
 
    // Getter for Product Name
    public String getProductName() {
        return productName;
    }
 
    // Setter for Product Name
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    // Getter for Quantity
    public int getQuanity() {
        return quanity;
    }
 
    // Setter for Quantity
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
 
    // Getter for Price
    public double getPrice() {
        return price;
    }
 
    // Setter for Price
    public void setPrice(double price) {
        this.price = price;
    }
 
    // Getter for Amount
    public double getAmount() {
        return amount;
    }
 
    // Setter for Amount
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
