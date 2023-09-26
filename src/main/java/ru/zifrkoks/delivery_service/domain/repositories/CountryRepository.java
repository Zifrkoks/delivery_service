package ru.zifrkoks.delivery_service.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.zifrkoks.delivery_service.domain.models.address.Country;

public interface CountryRepository extends JpaRepository<Country,Long> {
    
}
