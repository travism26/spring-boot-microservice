package com.rickjms.microservices.inventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickjms.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);

    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, int quantity);
}