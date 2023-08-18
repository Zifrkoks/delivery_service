package ru.zifrkoks.delivery_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.models.store.StoreReview;

public interface StoreReviewRepository extends JpaRepository<StoreReview, Long>{
    
}
