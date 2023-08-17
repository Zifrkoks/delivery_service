package ru.zifrkoks.delivery_service.models.store;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.zifrkoks.delivery_service.models.user.User;

@Entity
@Table(name = "product_reviews")
@Data
@NoArgsConstructor
public class ProductReview {
    
    @Id
    private int id;


    private String text;

    private String rating;
    
    private LocalDateTime CreatedAt;



    //внешние ключи one to one------------------------------------------------------



    //внешние ключи one to many------------------------------------------------------



    //внешние ключи many to one------------------------------------------------------

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;

    
    //внешние ключи many to many------------------------------------------------------
}
