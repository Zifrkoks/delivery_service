package ru.zifrkoks.delivery_service.dtos.address;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.store.Store;
import ru.zifrkoks.delivery_service.dtos.user.User;

@Entity
@Table(name = "cities")
@Data
@NoArgsConstructor
public class City {
    
    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    //внешние ключи one to one------------------------------------------------------

    //внешние ключи one to many------------------------------------------------------

    //внешние ключи many to one------------------------------------------------------


    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    //внешние ключи many to many------------------------------------------------------

    @ManyToMany(mappedBy = "cities")
    private List<Store> stores = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "users_cities",
    joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private List<User> users = new ArrayList<>();
}
