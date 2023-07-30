package com.lm.app.model;

import java.util.ArrayList;
import java.util.List;

// This class represents a shopping cart, containing customer information and a list of cart lines (products and their quantities)
public class CartInfo {
    
    // Order number
    private int orderNum;
    
    // Customer information
    private CustomerInfo customerInfo;
    
    // List of cart lines (products and their quantities)
    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
    
    // Constructor
    public CartInfo() {
    }
    
    // Getters and Setters
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<CartLineInfo> getCartLines() {
        return this.cartLines;
    }
    
    // Find a cart line by product code
    private CartLineInfo findLineByCode(String code) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getProductInfo().getCode().equals(code)) {
                return line;
            }
        }
        return null;
    }
    
    // Add a product to the cart with specified quantity
    public void addProduct(ProductInfo productInfo, int quantity) {
        CartLineInfo line = this.findLineByCode(productInfo.getCode());

        if (line == null) {
            line = new CartLineInfo();
            line.setQuantity(0);
            line.setProductInfo(productInfo);
            this.cartLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }
    
    // Validate the cart (currently empty implementation)
    public void validate() {
    }
    
    // Update the quantity of a product in the cart
    public void updateProduct(String code, int quantity) {
        CartLineInfo line = this.findLineByCode(code);

        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }
    
    // Remove a product from the cart
    public void removeProduct(ProductInfo productInfo) {
        CartLineInfo line = this.findLineByCode(productInfo.getCode());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }
    
    // Check if the cart is empty
    public boolean isEmpty() {
        return this.cartLines.isEmpty();
    }
    
    // Check if the customer information is valid
    public boolean isValidCustomer() {
        return this.customerInfo != null && this.customerInfo.isValid();
    }
    
    // Get the total quantity of all products in the cart
    public int getQuantityTotal() {
        int quantity = 0;
        for (CartLineInfo line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }
    
    // Get the total amount of all products in the cart
    public double getAmountTotal() {
        double total = 0;
        for (CartLineInfo line : this.cartLines) {
            total += line.getAmount();
        }
        return total;
    }
    
    // Update the quantity of products in the cart based on another cart
    public void updateQuantity(CartInfo cartForm) {
        if (cartForm != null) {
            List<CartLineInfo> lines = cartForm.getCartLines();
            for (CartLineInfo line : lines) {
                this.updateProduct(line.getProductInfo().getCode(), line.getQuantity());
            }
        }
    }
}