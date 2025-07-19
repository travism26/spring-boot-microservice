package com.rickjms.microservices.order.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rickjms.microservices.order.dto.OrderRequest;
import com.rickjms.microservices.order.model.Order;
import com.rickjms.microservices.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        // Map OrderRequest to Order
        // Save the Order
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderNumber(orderRequest.orderNumber());
        order.setSkuCode(orderRequest.skuCode());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);
    }
}
