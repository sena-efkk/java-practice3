package com.corejava.commerce.app;

import com.corejava.commerce.catalog.Category;
import com.corejava.commerce.catalog.Product;
import com.corejava.commerce.catalog.ProductCatalogService;

import java.math.BigDecimal;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Category elektronik = new Category(1L, "Elektronik");
        Category kitap = new Category(2L, "Kitap");

        Product p1 = new Product(1L, "Edebiyat Kitabı", BigDecimal.valueOf(60), 11, kitap);
        Product p2 = new Product(2L, "tarihkitabı", BigDecimal.valueOf(50), 22, kitap);
        Product p3 = new Product(3L, "bilgisayar", BigDecimal.valueOf(700), 33, elektronik);

        ProductCatalogService pcs =new ProductCatalogService();
        pcs.addProduct(p1);
        pcs.addProduct(p2);
        pcs.addProduct(p3);
        pcs.fndById(2L);
        pcs.changeProductCategory(3L, kitap);

        pcs.changeProductPrice(BigDecimal.valueOf(500),1L);

//        p1.decreaseStock(1);
//        p1.increaseStock(1);
//
//        p2.changePrice(BigDecimal.valueOf(100));
//        p3.changeCategory(kitap);

        pcs.decreaseProductStock(1L, 1);
        pcs.increaseProductStock(1L, 1);
        pcs.changeProductPrice(BigDecimal.valueOf(500), 1L);


        try {
            p1.decreaseStock(100);
        } catch (IllegalStateException exception) {
            System.out.println("Stok hatası: " + exception.getMessage());
        }

        printProduct(p1);
        printProduct(p2);
        printProduct(p3);

        List<Product> kitapUrunleri = pcs.findByCategory(kitap);

        for (Product product : kitapUrunleri) {
            printProduct(product);
        }
    }
    private static void printProduct(Product product) {
        System.out.println("--- PRODUCT ---");
        System.out.println("Id: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Category: " + product.getCategory().getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Stock: " + product.getStockQuantity());
    }
}