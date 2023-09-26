package ru.zifrkoks.delivery_service.domain.models.courier;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courier_data")
@Data
@NoArgsConstructor
public class CourierData {
    @Id
    private long id;

    private String name;

    private String surname;

    private String patronymic;

    private String passportData;

    private boolean isActive;

    private boolean isVerifiedAccount;

    //внешние ключи one to one------------------------------------------------------


    @OneToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    private Courier courier;


    
    //внешние ключи one to many------------------------------------------------------

    //внешние ключи many to one------------------------------------------------------

    //внешние ключи many to many------------------------------------------------------
}
