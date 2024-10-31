package com.example.eticaret.DTO;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;

    //Constructor
    public ProductDTO(){
    }
    public ProductDTO(Long id,String name,String description,BigDecimal price,int stockQuantity) {
        this.id=id;
        this.description=description;
        this.name=name;
        this.price=price;
        this.stockQuantity=stockQuantity;
    }
    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
