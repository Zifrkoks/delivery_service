package ru.zifrkoks.delivery_service.models.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.models.store.Product;

@Entity
@Data
@NoArgsConstructor
@Table(name = "basket_items")
public class BasketItem {
    
    @Id
    private long id;

    private int count;

    //внешние ключи one to one------------------------------------------------------

    

    //внешние ключи one to many------------------------------------------------------

    

    //внешние ключи many to one------------------------------------------------------


    @ManyToOne
    @JoinColumn(name = "basket_id", referencedColumnName = "id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    //внешние ключи many to many------------------------------------------------------
}
