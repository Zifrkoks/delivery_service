package ru.zifrkoks.delivery_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.models.address.City;

public interface CityRepository extends JpaRepository<City,Long> {
    
}
