package com.lm.app.form;

import com.lm.app.model.CustomerInfo;

public class CustomerForm {
 
    // Customer attributes
    private String name;
    

    private String address;
    

    private String email;
    

    private String phone;
 
    // Boolean to check if customer form is valid
    private boolean valid;
 
    // Default constructor
    public CustomerForm() {
 
    }
 
    // Constructor that takes a CustomerInfo object
    public CustomerForm(CustomerInfo customerInfo) {
        if (customerInfo != null) {
            this.name = customerInfo.getName();
            this.address = customerInfo.getAddress();
            this.email = customerInfo.getEmail();
            this.phone = customerInfo.getPhone();
        }
    }
 
    // Getter and setter methods for the fields
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public boolean isValid() {
        return valid;
    }
 
    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
