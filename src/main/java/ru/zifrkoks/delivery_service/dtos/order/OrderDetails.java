package ru.zifrkoks.delivery_service.dtos.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "orders_details")
@NoArgsConstructor
public class OrderDetails {

    @Id
    private long id;


    @Column(nullable = false)
    private long sumCast;


    @Column(nullable = false)
    private boolean isCash;


    private String message;


    
    //внешние ключи one to one------------------------------------------------------
    @OneToOne
    private Order order;

    //внешние ключи one to many------------------------------------------------------

    //внешние ключи many to one------------------------------------------------------

    //внешние ключи many to many------------------------------------------------------


}
