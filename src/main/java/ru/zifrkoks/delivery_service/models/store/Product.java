package ru.zifrkoks.delivery_service.models.store;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.models.user.User;

@Entity
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    private long id;


    private int cost;


    private String name;


    private String description;


    private int rating;


    
    //внешние ключи one to one------------------------------------------------------



    //внешние ключи one to many------------------------------------------------------

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductReview> review = new HashSet<>();

    //внешние ключи many to one------------------------------------------------------


    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;



    //внешние ключи many to many------------------------------------------------------


    @ManyToMany
    @JoinTable(
        name = "users_and_favorite_products",
        joinColumns = 
            @JoinColumn(name = "product_id", referencedColumnName = "id"),
        inverseJoinColumns = 
            @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Set<User> usersMarkedProductFavorite = new HashSet<>();



}
