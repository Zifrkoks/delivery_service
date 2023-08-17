package ru.zifrkoks.delivery_service.models.address;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
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

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private Set<City> cities = new HashSet<>();
    //внешние ключи many to one------------------------------------------------------

    //внешние ключи many to many------------------------------------------------------
}
