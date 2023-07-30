// Defines the package
package com.lm.app.entity;

// Imports necessary libraries
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Annotation to specify that this class is an entity
@Entity

// Annotation to specify the table to which this entity is mapped
@Table(name = "Accounts")
public class Account implements Serializable {

    // serialVersionUID for the serialization runtime to associate with a class descriptor.
    private static final long serialVersionUID = -2054386655979281969L;

    // Constants to define the roles
    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

    // Annotation to specify the primary key field in the table
    @Id
    @Column(name = "User_Name", length = 20, nullable = false)
    private String userName;

    // Encrypted password of the user
    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;

    // Specifies if the user account is active or not
    @Column(name = "Active", length = 1, nullable = false)
    private boolean active;

    // Specifies the role of the user
    @Column(name = "User_Role", length = 20, nullable = false)
    private String userRole;

    // Getter and setter methods for the fields
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    // Overriding the toString() method for debugging purpose
    @Override
    public String toString() {
        return "[" + this.userName + "," + this.encrytedPassword + "," + this.userRole + "]";
    }
}
