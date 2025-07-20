package com.rickjms.microservices.order.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.rickjms.microservices.order.client.InventoryClient;
import com.rickjms.microservices.order.dto.OrderRequest;
import com.rickjms.microservices.order.model.Order;
import com.rickjms.microservices.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        log.info("Order Service: Placing Order {}", orderRequest);

        var result = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (!result) {
            log.error("Product is not in stock, please try again later");
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

        // Send order created event to RabbitMQ
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(orderRequest.skuCode());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);
    }
}
