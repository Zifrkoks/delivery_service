package ru.zifrkoks.delivery_service.dtos.address;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coutries")
@Data
@NoArgsConstructor
public class Country {
    
    @Id
    private long id;

    @Column(nullable = false)
    private String name;


    //внешние ключи one to one------------------------------------------------------
    
    //внешние ключи one to many------------------------------------------------------

    @OneToMany(mappedBy = "country")
    private List<City> cities = new ArrayList<>();
    //внешние ключи many to one------------------------------------------------------

    //внешние ключи many to many------------------------------------------------------
}
