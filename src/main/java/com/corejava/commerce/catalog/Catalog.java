package com.corejava.commerce.catalog;

public class Catalog {
    private Long id;
    private String name;

    public Catalog(String name){
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }

}
