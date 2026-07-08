package com.prasthanam.tours.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "packages")
public class Package {
    @Id
    private String id;
    private String title;

    public Package() {}

    public Package(String title) {
        this.title = title;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
