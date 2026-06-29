package com.corejava.commerce.cart;

import com.corejava.commerce.catalog.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private List<CartItem> items;

    public Cart(){
        this.items = new ArrayList<>();

    }

    public void addProduct(Product product, int newquantity){
        //sepete urun ekleme etodu
        CartItem ci =new CartItem(product,newquantity);
        for(CartItem c:items){
            if(c.getProduct().hasEnoughStock(newquantity)){
                items.add(ci);

            }
            throw new IllegalArgumentException("Stok yetersiz.");

        }

    }

    //sepetin tamamının listesi isteniuor
    public List<CartItem> getItems(){
        //Sepetteki satırları görmek istiyorsam Cart.getItems() kullanmalıyım. -> bu ne demek anlamadım?
        List<CartItem> listesi= new ArrayList<>();
        for (CartItem i :items){
            listesi.add(i);
        }
        return listesi;
    }

    public BigDecimal getTotalPrice(){
    //Sepetteki tüm ürünlerin toplam fiyatını hesapla.
        BigDecimal total;
        for(CartItem item:items){

            //Sepetin genel toplamını istiyorsam Cart.getTotalPrice() kullanmalıyım.-> yazamadım syntaxını
        }
    return null;//ne dondurcemi bilmediğim için şuan boş bıraktım bilerek yani.
    }

    public boolean isEmpty(){
        //Sepette hiç ürün var mı?

        return items.isEmpty();
    }

    public void clear(){
        items.clear();
    }

}
