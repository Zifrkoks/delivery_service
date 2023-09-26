package ru.zifrkoks.delivery_service.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.domain.models.order.Order;

public interface OrderRepository  extends JpaRepository<Order,Long> {
    
}
