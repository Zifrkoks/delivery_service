package ru.zifrkoks.delivery_service.dtos.courier;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    
    
    @OneToOne(mappedBy = "courier")
    private CourierData courierData;



    //внешние ключи one to many------------------------------------------------------

    @OneToMany(mappedBy = "courier")
    private List<Order> orders = new ArrayList<>();
    
    //внешние ключи many to one------------------------------------------------------

    //внешние ключи many to many------------------------------------------------------
}
