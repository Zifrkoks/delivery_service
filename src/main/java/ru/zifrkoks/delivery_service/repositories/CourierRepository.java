package ru.zifrkoks.delivery_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.zifrkoks.delivery_service.models.courier.Courier;

public interface CourierRepository  extends JpaRepository<Courier,Long> {
    public Courier findByUsername(String username);
    @Query("select e from Courier e where e.username = :username and e.password = :password")
    public Courier tryToAuthorize(@Param("username")String username,@Param("password")String password);
}
