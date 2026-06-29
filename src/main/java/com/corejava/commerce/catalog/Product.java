package com.corejava.commerce.catalog;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private int stockQuantity;
    private Category category;

    public Product(Long id,
                   String name,
                   BigDecimal price,
                   int stockQuantity,
                   Category category) {
        if(id==null || id.compareTo(0L)<=0) {
            throw new IllegalArgumentException("id null,o,negatif olamaz.");

        }
        this.id= id;
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("name null,o,negatif olamaz.");
        }
        this.name = name;

        changePrice(price);

        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Başlangıç stoğu negatif olamaz.");
        }

        this.stockQuantity = stockQuantity;
        if(category==null){
            throw new IllegalArgumentException("category null olamaz.");
        }
        this.category = category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);

    }
    public Long getId() {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void changePrice(BigDecimal price){
        if(price == null){
            throw new IllegalArgumentException("Fiyat boş olamaz.");
        }

        if(price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Fiyat sıfır veya negatif olamaz.");
        }

        this.price = price;
    }

    public boolean hasEnoughStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Miktar pozitif olmalı.");
        }

        return stockQuantity >= quantity;
    }

    public int getStockQuantity(){
        return stockQuantity;
    }

    public void increaseStock(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Miktar pozitif olmalı.");
        }

        stockQuantity += amount;
    }

    public void decreaseStock(int amount){

        if(amount <= 0){
            throw new IllegalArgumentException("Miktar pozitif olmalı.");
        }

        if(stockQuantity < amount){
            throw new IllegalStateException("Yetersiz stok.");
        }

        stockQuantity -= amount;
    }

    public Category getCategory() {
        return category;
    }

    public void changeCategory(Category newCategory){
        if(newCategory == null){
            throw new IllegalArgumentException("kategori null olamaz");
        }
        this.category = newCategory;
    }



}
