package ru.zifrkoks.delivery_service.dtos.store;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.dtos.user.User;

@Entity
@Table(name = "stores_reviews")
@Data
@NoArgsConstructor
public class StoreReview {
    
    @Id
    private long id;

    private String text;

    private int rating;

    private LocalDateTime CreatedAt;

    //внешние ключи one to one------------------------------------------------------


    //внешние ключи one to many------------------------------------------------------


    
    //внешние ключи many to one------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User author;

    //внешние ключи many to many------------------------------------------------------
}
