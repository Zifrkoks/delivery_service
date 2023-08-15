package ru.zifrkoks.delivery_service.dtos.store;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.order.Order;
import ru.zifrkoks.delivery_service.dtos.user.User;

@Entity
@Data
@Table(name = "stores")
@NoArgsConstructor
public class Store {
    @Id
    private long id;


    private String name;


    private String description;


    //внешние ключи one to one------------------------------------------------------


    //внешние ключи one to many------------------------------------------------------


    @OneToMany(mappedBy = "store")
    private List<Order> orders = new ArrayList<>();


    @OneToMany(mappedBy = "store")
    private List<Product> products = new ArrayList<>();
    
    //внешние ключи many to one------------------------------------------------------



    //внешние ключи many to many------------------------------------------------------


    @ManyToMany
    @JoinTable(
        name = "users_and_favorite_store",
        joinColumns = 
            @JoinColumn(name = "store_id", referencedColumnName = "id"),
        inverseJoinColumns = 
            @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<User> usersMarkedStoreFavorite = new ArrayList<>();
}
