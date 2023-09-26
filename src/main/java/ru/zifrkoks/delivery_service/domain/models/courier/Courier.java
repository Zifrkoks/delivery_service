package ru.zifrkoks.delivery_service.domain.models.courier;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.domain.models.address.City;
import ru.zifrkoks.delivery_service.domain.models.order.Order;
@Entity
@Table(name = "couriers")
@Data
@NoArgsConstructor
public class Courier {
    
    @Id
    private long id;
    @Column(nullable = false,unique = true,length = 30)
    private String username;
    
    @Column(nullable = false, length = 30)
    private String password;

    private int rating;


    @Column(name = "email",unique = true)
    private String email;


    @Column(name = "phone",unique = true, nullable = false)
    private String phone;

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
