package com.prasthanam.tours.service;

import com.prasthanam.tours.model.Package;
import com.prasthanam.tours.repository.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {
    private final PackageRepository repository;

    public PackageService(PackageRepository repository) {
        this.repository = repository;
    }

    public Package create(Package pkg) {
        return repository.save(pkg);
    }

    public List<Package> getAll() {
        return repository.findAll();
    }

    public Optional<Package> getById(String id) {
        return repository.findById(id);
    }

    public Package update(String id, Package pkg) {
        pkg.setId(id);
        return repository.save(pkg);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}

