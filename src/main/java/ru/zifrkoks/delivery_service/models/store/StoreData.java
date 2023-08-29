package ru.zifrkoks.delivery_service.models.store;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "store_data")
@Data
@NoArgsConstructor
public class StoreData {
    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    private String description;
    
    @Column(nullable = false)
    private String address;


    private String socialNetworks;

    @OneToOne
    @JoinColumn(name = "store_id",referencedColumnName = "id")
    private Store store;
}
