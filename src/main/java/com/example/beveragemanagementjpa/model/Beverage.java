package com.example.beveragemanagementjpa.model;

import javax.persistence.*;

@Entity
@Table(name = "beverage")
public class Beverage {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private int quantity;
    private int quantitySold;
    private double price;
    private String detail;

    public Beverage() {
    }

    public Beverage(Long id, String name, String category, int quantity, int quantitySold, double price, String detail) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.quantitySold = quantitySold;
        this.price = price;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}