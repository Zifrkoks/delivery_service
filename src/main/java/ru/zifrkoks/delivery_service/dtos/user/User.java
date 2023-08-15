package ru.zifrkoks.delivery_service.dtos.user;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.order.Order;
import ru.zifrkoks.delivery_service.dtos.store.Store;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private String id;


    @Column(nullable = false,unique = true)
    private String username;


    @Column(nullable = false)
    private String password;


    @Column(name = "email",unique = true)
    private String email;


    @Column(name = "phone",unique = true, nullable = false)
    private String phone;



    //внешние ключи one to one------------------------------------------------------


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userdate_id",referencedColumnName = "id")
    private UserData userData;


    //внешние ключи one to many------------------------------------------------------


    @OneToMany(mappedBy = "customer")
    List<Order> orders = new ArrayList<>();


    //внешние ключи many to one------------------------------------------------------





    //внешние ключи many to many------------------------------------------------------


    @ManyToMany(mappedBy = "usersMarkedStoreFavorite")
    private List<Store> favoriteStores = new ArrayList<>();
}
