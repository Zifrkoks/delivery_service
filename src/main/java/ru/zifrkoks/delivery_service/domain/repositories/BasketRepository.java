package ru.zifrkoks.delivery_service.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.domain.models.user.Basket;

public interface BasketRepository extends JpaRepository<Basket,Long> {
    
}
