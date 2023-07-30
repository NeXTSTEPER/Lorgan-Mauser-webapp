package com.lm.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity

// Map this entity to the "Orders" table and set the unique constraint for the "Order_Num" column
@Table(name = "Orders", //
        uniqueConstraints = { @UniqueConstraint(columnNames = "Order_Num") })
public class Order implements Serializable {
 
    // Specify the serialVersionUID for the serialization runtime
    private static final long serialVersionUID = -2576670215015463100L;
 
    // Specify the primary key field in the table
    @Id
    @Column(name = "ID", length = 50)
    private String id;
 
    // Date when the order was placed
    @Column(name = "Order_Date", nullable = false)
    private Date orderDate;
 
    // Unique order number
    @Column(name = "Order_Num", nullable = false)
    private int orderNum;
 
    // Total amount of the order
    @Column(name = "Amount", nullable = false)
    private double amount;
 
    // Customer's name
    @Column(name = "Customer_Name", length = 255, nullable = false)
    private String customerName;
 
    // Customer's address
    @Column(name = "Customer_Address", length = 255, nullable = false)
    private String customerAddress;
 
    // Customer's email
    @Column(name = "Customer_Email", length = 128, nullable = false)
    private String customerEmail;
 
    // Customer's phone number
    @Column(name = "Customer_Phone", length = 128, nullable = false)
    private String customerPhone;

    // Getter and setter methods for the fields
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public Date getOrderDate() {
        return orderDate;
    }
 
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
 
    public int getOrderNum() {
        return orderNum;
    }
 
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
 
    public double getAmount() {
        return amount;
    }
 
    public void setAmount(double amount) {
        this.amount = amount;
    }
 
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    public String getCustomerAddress() {
        return customerAddress;
    }
 
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
 
    public String getCustomerEmail() {
        return customerEmail;
    }
 
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
 
    public String getCustomerPhone() {
        return customerPhone;
    }
 
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
