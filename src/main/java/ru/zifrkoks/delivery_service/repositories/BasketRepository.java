package ru.zifrkoks.delivery_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.models.user.Basket;

public interface BasketRepository extends JpaRepository<Basket,Long> {
    
}
