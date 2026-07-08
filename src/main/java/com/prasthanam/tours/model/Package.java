package com.prasthanam.tours.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "packages")
public class Package {
    @Id
    private String id;
    private String title;
    private int price;

    public Package() {}

    public Package(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getId() { return id; }
    public void setId(String id){this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
