package com.prasthanam.tours.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.prasthanam.tours.model.Package;

public interface PackageRepository extends MongoRepository<Package, String> {
}
