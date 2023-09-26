package ru.zifrkoks.delivery_service.domain.models.address;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
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
import ru.zifrkoks.delivery_service.domain.models.courier.Courier;
import ru.zifrkoks.delivery_service.domain.models.store.Store;
import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;

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

    @OneToMany(mappedBy = "city")
    private Set<Courier> activeCouriers = new HashSet<>();

    //внешние ключи many to one------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    //внешние ключи many to many------------------------------------------------------

    @ManyToMany(mappedBy = "cities")
    private Set<Store> stores = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "users_cities",
    joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Set<UserAccount> users = new HashSet<>();


    
}
