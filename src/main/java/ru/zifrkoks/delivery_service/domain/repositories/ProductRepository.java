package ru.zifrkoks.delivery_service.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.domain.models.store.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
