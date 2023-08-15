package ru.zifrkoks.delivery_service.dtos.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.store.Product;

@Entity
@Data
@Table(name = "orders_items")
@NoArgsConstructor
public class OrderItem {
    
    @Id
    private long id;

    private int count;

    //внешние ключи many to one------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id", nullable = false)
    private Order order;


    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
    //внешние ключи many to many------------------------------------------------------

}
