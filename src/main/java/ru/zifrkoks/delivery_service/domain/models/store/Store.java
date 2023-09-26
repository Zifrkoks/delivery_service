package ru.zifrkoks.delivery_service.domain.models.store;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.domain.models.address.City;
import ru.zifrkoks.delivery_service.domain.models.order.Order;
import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;

@Entity
@Data
@Table(name = "stores")
@NoArgsConstructor
public class Store {
    @Id
    private long id;

    @Column(nullable = false,unique = true, length = 30)
    private String username;


    @Column(nullable = false, length = 30)
    private String password;

    @Column(name = "email",unique = true)
    private String email;


    @Column(name = "phone",unique = true, nullable = false)
    private String phone;

    private int rating;
    //внешние ключи one to one------------------------------------------------------

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private StoreData storeData;

    //внешние ключи one to many------------------------------------------------------


    @OneToMany(mappedBy = "store")
    private Set<Order> orders = new HashSet<>();


    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<>();
    
    
    @OneToMany(mappedBy = "store", cascade =  CascadeType.ALL)
    private Set<StoreReview> storeReviews = new HashSet<>();
    //внешние ключи many to one------------------------------------------------------

    

    //внешние ключи many to many------------------------------------------------------


    @ManyToMany
    @JoinTable(
        name = "users_and_favorite_store",
        joinColumns = 
            @JoinColumn(name = "store_id", referencedColumnName = "id"),
        inverseJoinColumns = 
            @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<UserAccount> usersMarkedStoreFavorite = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "cities_stores",
    joinColumns = 
        @JoinColumn(name = "store_id", referencedColumnName = "id"),
    inverseJoinColumns = 
        @JoinColumn(name = "city_id", referencedColumnName = "id"))
    private Set<City> cities = new HashSet<>();
}
