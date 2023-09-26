package ru.zifrkoks.delivery_service.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.domain.models.store.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview,Long> {
    
}
