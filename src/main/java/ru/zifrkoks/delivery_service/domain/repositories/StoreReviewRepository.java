package ru.zifrkoks.delivery_service.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.domain.models.store.StoreReview;

public interface StoreReviewRepository extends JpaRepository<StoreReview, Long>{
    
}
