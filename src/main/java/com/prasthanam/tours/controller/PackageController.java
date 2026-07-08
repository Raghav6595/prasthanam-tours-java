package com.prasthanam.tours.controller;

import com.prasthanam.tours.model.Package;
import com.prasthanam.tours.service.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/packages")
public class PackageController {
    private final PackageService service;

    public PackageController(PackageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Package> create(@RequestBody Package pkg) {
        return ResponseEntity.ok(service.create(pkg));
    }

    @GetMapping
    public ResponseEntity<List<Package>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getById(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Package> update(@PathVariable String id, @RequestBody Package pkg) {
        return ResponseEntity.ok(service.update(id, pkg));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

