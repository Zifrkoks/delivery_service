package ru.zifrkoks.delivery_service.dtos.store;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.address.City;
import ru.zifrkoks.delivery_service.dtos.order.Order;
import ru.zifrkoks.delivery_service.dtos.user.User;

@Entity
@Data
@Table(name = "stores")
@NoArgsConstructor
public class Store {
    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;

    private int rating;
    //внешние ключи one to one------------------------------------------------------

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private StoreData storeData;

    //внешние ключи one to many------------------------------------------------------


    @OneToMany(mappedBy = "store")
    private List<Order> orders = new ArrayList<>();


    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
    
    
    @OneToMany(mappedBy = "store", cascade =  CascadeType.ALL)
    private List<StoreReview> storeReviews = new ArrayList<>();
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


    @ManyToMany
    @JoinTable(name = "cities_stores",
    joinColumns = 
        @JoinColumn(name = "store_id", referencedColumnName = "id"),
    inverseJoinColumns = 
        @JoinColumn(name = "city_id", referencedColumnName = "id"))
    private List<City> cities = new ArrayList<>();
}
