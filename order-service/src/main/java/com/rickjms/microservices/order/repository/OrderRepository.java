package com.rickjms.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickjms.microservices.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
