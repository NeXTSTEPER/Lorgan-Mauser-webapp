
package com.lm.app.form;


import org.springframework.web.multipart.MultipartFile;
import com.lm.app.entity.Product;

public class ProductForm {
    // Product attributes
    private String code;
    
    private String name;
    
    private double price;
 
    // Boolean to check if it's a new product
    private boolean newProduct = false;
 
    // File that will be uploaded for this product
    private MultipartFile fileData;
 
    // Default constructor
    // Sets newProduct as true as it's a new instance
    public ProductForm() {
        this.newProduct= true;
    }
 
    // Constructor that takes a Product object
    // Initializes the form with existing product data
    public ProductForm(Product product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.price = product.getPrice();
    }
 
    // Getter and setter methods for the fields
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    // Getter and setter for the uploaded file data
    public MultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(MultipartFile fileData) {
        this.fileData = fileData;
    }
 
    // Check if it's a new product
    public boolean isNewProduct() {
        return newProduct;
    }
 
    // Set if it's a new product
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
}
