package ru.zifrkoks.delivery_service.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.domain.models.address.City;

public interface CityRepository extends JpaRepository<City,Long> {
    
}
