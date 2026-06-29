package com.corejava.commerce.catalog;

public class Category {
    private Long id;
    private String name;

    public Category(Long id, String name) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Kategori id değeri pozitif olmalı.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Kategori adı boş olamaz.");
        }

        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void rename(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("Kategori adı boş olamaz.");
        }

        this.name = newName;
    }

}
