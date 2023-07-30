package com.lm.app.model;

public class CartLineInfo {
    
    // Product information 
    private ProductInfo productInfo;
    
    // Quantity of the product in the cart
    private int quantity;
  
    // Default constructor
    // Sets the quantity to zero
    public CartLineInfo() {
        this.quantity = 0;
    }
  
    // Getter method for ProductInfo
    public ProductInfo getProductInfo() {
        return productInfo;
    }
  
    // Setter method for ProductInfo
    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }
  
    // Getter method for quantity
    public int getQuantity() {
        return quantity;
    }
  
    // Setter method for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
  
    // Get the total amount for this line
    // Which is product's price times the quantity
    public double getAmount() {
        return this.productInfo.getPrice() * this.quantity;
    }
}
