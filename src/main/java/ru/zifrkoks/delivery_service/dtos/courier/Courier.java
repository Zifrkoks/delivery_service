package ru.zifrkoks.delivery_service.dtos.courier;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.address.City;
import ru.zifrkoks.delivery_service.dtos.order.Order;
@Entity
@Table(name = "couriers")
@Data
@NoArgsConstructor
public class Courier {
    
    @Id
    private long id;

    private String username;

    private String password;

    private int rating;


    //внешние ключи one to one------------------------------------------------------
    
    
    @OneToOne(mappedBy = "courier", cascade = CascadeType.ALL)
    private CourierData courierData;



    //внешние ключи one to many------------------------------------------------------

    @OneToMany(mappedBy = "courier")
    private Set<Order> orders = new HashSet<>();
    
    //внешние ключи many to one------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
    //внешние ключи many to many------------------------------------------------------

    
    
}
