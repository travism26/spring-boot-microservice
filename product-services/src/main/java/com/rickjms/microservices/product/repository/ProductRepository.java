package com.rickjms.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rickjms.microservices.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}