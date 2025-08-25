package com.ecommerce.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders") // Avoid conflict with SQL keyword "order"
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Double amount;
    private LocalDate orderDate;

    // Many Orders belong to one User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Order() {
    }

    public Order(String productName, Double amount, LocalDate orderDate) {
        this.productName = productName;
        this.amount = amount;
        this.orderDate = orderDate;
    }
    public Order(Long id, String productName, Double amount, LocalDate orderDate) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.orderDate = orderDate;
    }
    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", productName=" + productName +
                ", amount=" + amount + ", orderDate=" + orderDate + "]";
    }
}
