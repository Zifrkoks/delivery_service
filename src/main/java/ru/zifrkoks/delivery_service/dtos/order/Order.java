package ru.zifrkoks.delivery_service.dtos.order;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.store.Store;
import ru.zifrkoks.delivery_service.dtos.user.User;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    private long id;



    //внешние ключи one to one------------------------------------------------------
    @OneToOne(mappedBy = "order")
    private OrderDetails orderDetails;
    


    //внешние ключи one to many------------------------------------------------------
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    //внешние ключи many to one------------------------------------------------------


    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private User customer;


    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;


    //внешние ключи many to one------------------------------------------------------

    
    
}
