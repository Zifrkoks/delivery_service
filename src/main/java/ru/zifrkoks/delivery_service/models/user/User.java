package ru.zifrkoks.delivery_service.models.user;

import java.util.HashSet;
import java.util.Set;

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
import ru.zifrkoks.delivery_service.models.address.City;
import ru.zifrkoks.delivery_service.models.order.Order;
import ru.zifrkoks.delivery_service.models.store.Product;
import ru.zifrkoks.delivery_service.models.store.ProductReview;
import ru.zifrkoks.delivery_service.models.store.Store;
import ru.zifrkoks.delivery_service.models.store.StoreReview;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private String id;


    @Column(nullable = false,unique = true,length = 30)
    private String username;


    @Column(nullable = false, length = 30)
    private String password;


    @Column(name = "email",unique = true)
    private String email;


    @Column(name = "phone",unique = true, nullable = false)
    private String phone;

    private String address;

    //внешние ключи one to one------------------------------------------------------

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Basket basket;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userdate_id",referencedColumnName = "id")
    private UserData userData;


    //внешние ключи one to many------------------------------------------------------



    @OneToMany(mappedBy = "author")
    private Set<ProductReview> productReviews = new HashSet<>();


    @OneToMany(mappedBy = "author")
    private Set<StoreReview> storeReviews = new HashSet<>();


    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new HashSet<>();


    //внешние ключи many to one------------------------------------------------------





    //внешние ключи many to many------------------------------------------------------


    @ManyToMany(mappedBy = "usersMarkedStoreFavorite")
    private Set<Store> favoriteStores = new HashSet<>();

    @ManyToMany(mappedBy = "usersMarkedProductFavorite")
    private Set<Product> favoriteProducts = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    private Set<City> cities = new HashSet<>();

}
