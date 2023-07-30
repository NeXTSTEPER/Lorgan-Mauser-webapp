package com.lm.app.model;

import com.lm.app.form.CustomerForm;

// Class representing a customer's information
public class CustomerInfo {
    
    // Customer's name
    private String name;
    
    // Customer's address
    private String address;
    
    // Customer's email
    private String email;
    
    // Customer's phone
    private String phone;

    // Validity status of the customer
    private boolean valid;

    // Default constructor
    public CustomerInfo() {
    }
    
    // Constructor that takes a CustomerForm object and extracts the information
    public CustomerInfo(CustomerForm customerForm) {
        this.name = customerForm.getName();
        this.address = customerForm.getAddress();
        this.email = customerForm.getEmail();
        this.phone = customerForm.getPhone();
        this.valid = customerForm.isValid();
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for validity status
    public boolean isValid() {
        return valid;
    }

    // Setter for validity status
    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
