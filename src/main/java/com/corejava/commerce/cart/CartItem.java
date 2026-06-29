package com.corejava.commerce.cart;

import com.corejava.commerce.catalog.Product;
import com.corejava.commerce.catalog.ProductCatalogService;

import java.math.BigDecimal;
import java.util.ArrayList;

//CartItem: sepetteki tek bir satırı temsil eder.
public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product,int quantity){
        if(product==null){
            throw new IllegalArgumentException("Ürün boş olamaz.");

        }
        if(quantity<= 0 || product.hasEnoughStock(quantity)){
            throw new IllegalArgumentException("miktar 0 veya negatif olamaz.");

        }
        this.product=product;
        this.quantity=quantity;

    }

    public Product getProduct(){
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void increaseQuantity(int amount){
        this.quantity=quantity+amount;
    }

    public void decreaseQuantity(int amount){
        this.quantity=quantity-amount;

    }

    public BigDecimal getLineTotal(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }



}
