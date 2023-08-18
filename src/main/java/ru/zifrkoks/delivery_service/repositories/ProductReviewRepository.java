package ru.zifrkoks.delivery_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.models.store.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview,Long> {
    
}
