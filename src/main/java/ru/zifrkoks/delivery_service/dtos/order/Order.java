package ru.zifrkoks.delivery_service.dtos.order;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.courier.Courier;
import ru.zifrkoks.delivery_service.dtos.store.Store;
import ru.zifrkoks.delivery_service.dtos.user.User;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    private long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.CREATED;



    //внешние ключи one to one------------------------------------------------------
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private OrderDetails orderDetails;
    


    //внешние ключи one to many------------------------------------------------------
    
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems = new HashSet<>();


    //внешние ключи many to one------------------------------------------------------


    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private User customer;


    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;


    @ManyToOne
    @JoinColumn(name = "courier_id",referencedColumnName = "id")
    private Courier courier;

    //внешние ключи many to one------------------------------------------------------


    public enum OrderStatus {
        ERROR,
        CENCELED,
        CREATED,
        PREPARE,
        PREPARED,
        IN_DELIVERY,
        DELIVERED,
        COMPLETED,
    }
}
