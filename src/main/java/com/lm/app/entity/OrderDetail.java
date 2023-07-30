package com.lm.app.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

// Map this entity to the "Order_Details" table
@Table(name = "Order_Details")
public class OrderDetail implements Serializable {
 
    // Specify the serialVersionUID for the serialization runtime
    private static final long serialVersionUID = 7550745928843183535L;
 
    // Specify the primary key field in the table
    @Id
    @Column(name = "ID", length = 50, nullable = false)
    private String id;
 
    // Define a ManyToOne relationship with Order entity, with appropriate fetch type, join column, and foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Order order;
 
    // Define a ManyToOne relationship with Product entity, with appropriate fetch type, join column, and foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
    private Product product;
 
    // Quantity of the product in the order
    @Column(name = "Quanity", nullable = false)
    private int quanity;
 
    // Price per unit of the product
    @Column(name = "Price", nullable = false)
    private double price;
 
    // Total amount (price * quantity)
    @Column(name = "Amount", nullable = false)
    private double amount;

    // Getter and setter methods for the fields
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public Order getOrder() {
        return order;
    }
 
    public void setOrder(Order order) {
        this.order = order;
    }
 
    public Product getProduct() {
        return product;
    }
 
    public void setProduct(Product product) {
        this.product = product;
    }
 
    public int getQuanity() {
        return quanity;
    }
 
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public double getAmount() {
        return amount;
    }
 
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
