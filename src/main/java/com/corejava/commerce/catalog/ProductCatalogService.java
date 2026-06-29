package com.corejava.commerce.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductCatalogService {
    private List<Product> products = new ArrayList<>();


    private Map<Long, Product> productsMap = new HashMap<>();


    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Ürün boş bırakılamaz.");
        }
//        for (Product p : products) {
//            if (p.getId() == product.getId()) {
//                throw new IllegalArgumentException("...");
//
//            }
//
//        }
        if (productsMap.containsKey(product.getId())) {
            throw new IllegalArgumentException("Bu id ile ürün zaten var.");
        }

        products.add(product);
        productsMap.put(product.getId(), product);
    }

    public void changeProductCategory(Long productId, Category newCategory) {
        Product product = fndById(productId);
        product.changeCategory(newCategory);
    }
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
        //Asıl listeyi değil,listenin kopyasını dışarı veriyorum.

    }


    public Product fndById(Long id) {
//        if (productsMap.get(id) == null) {
//            throw new IllegalArgumentException("...");
//
//        }
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Ürün id değeri pozitif olmalı.");
        }
        Product product = productsMap.get(id);
        if (product == null) {
            throw new IllegalArgumentException("Ürün bulunamadı.");
        }

        return product;

//        for(int i=0;i<products.size() ;i++){
//            if(id == products.get(i).getId()){
//                return products.get(i);
//            }
//        }
//        throw new IllegalArgumentException("...");

    }


    public List<Product> findByCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Kategori null olamaz.");
        }

        List<Product> result = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().getId().equals(category.getId())) {
                result.add(product);
            }
        }

        return result;
    }

    //kategori adına göre ürünleri listele
    public List<Product> findByCategoryName(String name) {

       List<Product> urunlistesi = new ArrayList<>();
        for (Product p :products){
           if(p.getCategory().getName().equals(name)){
               urunlistesi.add(p);
           }
       }
        return urunlistesi;
    }


    public void changeProductPrice(BigDecimal price, Long productId) {
        //Bu id’ye sahip Product nesnesini bul ve product değişkenine koy.
        Product product1 = fndById(productId);

        //Bulduğun ürünün fiyatını değiştir.
        product1.changePrice(price);
    }

    public void increaseProductStock(Long productId, int quantity) {
        Product product = fndById(productId);
        product.increaseStock(quantity);
    }

    public void decreaseProductStock(Long productId, int quantity) {
        Product product = fndById(productId);
        product.decreaseStock(quantity);
    }

}
