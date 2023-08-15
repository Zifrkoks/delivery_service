package ru.zifrkoks.delivery_service.dtos.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users_data")
public class UserData {
    @Id
    @GeneratedValue
    private long id;


    @Column(length = 25)
    private String name;


    @Column(length = 25)
    private String surname;


    @Column(length = 25)
    private String patronymic;


    @Column(length = 11)
    private String passportData;


    //внешние ключи one to one------------------------------------------------------


    @OneToOne(mappedBy = "userData", cascade = CascadeType.ALL)
    private User user;


}
