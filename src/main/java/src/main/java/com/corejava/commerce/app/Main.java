package src.main.java.com.corejava.commerce.app;

import com.corejava.commerce.app.Category;
import com.corejava.commerce.app.Product;

import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {

        Category elektronik = new Category(1L, "Elektronik");
        Category kitap = new Category(2L, "Kitap");

        Product p1 = new Product(1L, "Edebiyat Kitabı", BigDecimal.valueOf(60), 11, kitap);
        Product p2 = new Product(2L, "tarihkitabı", BigDecimal.valueOf(50), 22, kitap);
        Product p3 = new Product(3L, "bilgisayar", BigDecimal.valueOf(700), 33, elektronik);


        p1.decreaseStock(1);
        p1.increaseStock(1);

        p2.changePrice(BigDecimal.valueOf(100));
        p3.changeCategory(kitap);

        try {
            p1.decreaseStock(100);
        } catch (IllegalStateException exception) {
            System.out.println("Stok hatası: " + exception.getMessage());
        }

        printProduct(p1);
        printProduct(p2);
        printProduct(p3);


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