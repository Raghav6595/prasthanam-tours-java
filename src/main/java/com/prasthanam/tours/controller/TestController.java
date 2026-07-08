package com.prasthanam.tours.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.prasthanam.tours.model.Package;
import com.prasthanam.tours.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class TestController {
    private final PackageRepository repo;
    @Value("${spring.data.mongodb.uri:NOT_FOUND}")
    private String mongoUri;

    public TestController(PackageRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/test")
    public List<Package> getAll() {
        return repo.findAll();
    }
}
