package com.ubicuosoft.mongodb.repository;

import com.ubicuosoft.mongodb.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
