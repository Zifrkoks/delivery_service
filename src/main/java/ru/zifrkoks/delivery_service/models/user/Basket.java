package ru.zifrkoks.delivery_service.models.user;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue
    private String id;

    
    //внешние ключи one to one------------------------------------------------------

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    //внешние ключи one to many------------------------------------------------------

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private Set<BasketItem> basketItems = new HashSet<>();
    //внешние ключи many to one------------------------------------------------------


    //внешние ключи many to many------------------------------------------------------


}
