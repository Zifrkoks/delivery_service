package ru.zifrkoks.delivery_service.models.user;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.models.store.Product;

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
    private List<BasketItem> basketItems = new ArrayList<>();
    //внешние ключи many to one------------------------------------------------------


    //внешние ключи many to many------------------------------------------------------


}
