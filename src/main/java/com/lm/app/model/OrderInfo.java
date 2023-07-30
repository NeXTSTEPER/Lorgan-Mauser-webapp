package com.lm.app.model;

import java.util.Date;
import java.util.List;

// Class representing an order information
public class OrderInfo {
    // Order ID
    private String id;

    // Date of the order
    private Date orderDate;

    // Order number
    private int orderNum;

    // Total amount for the order
    private double amount;

    // Customer's name
    private String customerName;

    // Customer's address
    private String customerAddress;

    // Customer's email
    private String customerEmail;

    // Customer's phone number
    private String customerPhone;

    // Detailed information about the order
    private List<OrderDetailInfo> details;

    // Default constructor
    public OrderInfo() {
    }

    // Constructor for creating an OrderInfo object with all necessary details.
    // Mostly used for Hibernate Query.
    public OrderInfo(String id, Date orderDate, int orderNum, double amount, 
                     String customerName, String customerAddress, 
                     String customerEmail, String customerPhone) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderNum = orderNum;
        this.amount = amount;

        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    // Getter for Order ID
    public String getId() {
        return id;
    }

    // Setter for Order ID
    public void setId(String id) {
        this.id = id;
    }

    // Getter for Order Date
    public Date getOrderDate() {
        return orderDate;
    }

    // Setter for Order Date
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    // Getter for Order Number
    public int getOrderNum() {
        return orderNum;
    }

    // Setter for Order Number
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    // Getter for Order Amount
    public double getAmount() {
        return amount;
    }

    // Setter for Order Amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter for Customer's Name
    public String getCustomerName() {
        return customerName;
    }

    // Setter for Customer's Name
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // Getter for Customer's Address
    public String getCustomerAddress() {
        return customerAddress;
    }

    // Setter for Customer's Address
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    // Getter for Customer's Email
    public String getCustomerEmail() {
        return customerEmail;
    }

    // Setter for Customer's Email
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    // Getter for Customer's Phone Number
    public String getCustomerPhone() {
        return customerPhone;
    }

    // Setter for Customer's Phone Number
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    // Getter for Order Details
    public List<OrderDetailInfo> getDetails() {
        return details;
    }

    // Setter for Order Details
    public void setDetails(List<OrderDetailInfo> details) {
        this.details = details;
    }

}
