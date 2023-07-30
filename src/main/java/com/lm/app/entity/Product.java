package com.lm.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

// Map this entity to the "Products" table
@Table(name = "Products")
public class Product implements Serializable {
 
    // Specify the serialVersionUID for the serialization runtime
    private static final long serialVersionUID = -1000119078147252957L;
 
    // Specify the primary key field in the table
    @Id
    @Column(name = "Code", length = 20, nullable = false)
    private String code;
 
    // Name of the product
    @Column(name = "Name", length = 255, nullable = false)
    private String name;
 
    // Price of the product
    @Column(name = "Price", nullable = false)
    private double price;
 
    // Image associated with the product (stored as a byte array)
    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;
     
    // Creation date of the product entry
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Create_Date", nullable = false)
    private Date createDate;
 
    // Default constructor
    public Product() {
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
 
    public Date getCreateDate() {
        return createDate;
    }
 
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
 
    public byte[] getImage() {
        return image;
    }
 
    public void setImage(byte[] image) {
        this.image = image;
    }
}
