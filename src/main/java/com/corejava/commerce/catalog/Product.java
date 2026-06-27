package com.corejava.commerce.catalog;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private int stockQuantity;
    private Catalog category;

    public Product(String name,
                   BigDecimal price,
                   int stockQuantity,
                   Catalog category) {

        this.name = name;
        changePrice(price);
        increaseStock(stockQuantity);
        this.category = category;
    }
    private void setStockQuantity(int stockQuantity){
        this.stockQuantity=stockQuantity;
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
            throw new IllegalArgumentException("Yetersiz stok.");
        }

        stockQuantity -= amount;
    }


    public void changeCategory(Catalog category){
        this.category = category;
    }

    public void changePrice(BigDecimal price){
        if(price == null){
            throw new IllegalArgumentException("Fiyat boş olamaz.");
        }

        if(price.compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Fiyat negatif olamaz.");
        }

        this.price = price;
    }
    private void setPrice(BigDecimal p){
        this.price=p;

    }

}
