package ru.zifrkoks.delivery_service.dtos.store;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.order.OrderItem;

@Entity
@Data
@NoArgsConstructor
@Table(name = "store_products")
public class Product {
    @Id
    private long id;


    private int cost;


    private String name;


    private String description;


    //внешние ключи one to one------------------------------------------------------


    //внешние ключи one to many------------------------------------------------------


    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems = new ArrayList<>();


    //внешние ключи many to one------------------------------------------------------


    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;



    //внешние ключи many to many------------------------------------------------------


    


}
