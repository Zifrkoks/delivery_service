package ru.zifrkoks.delivery_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.models.order.Order;

public interface OrderRepository  extends JpaRepository<Order,Long> {
    
}
