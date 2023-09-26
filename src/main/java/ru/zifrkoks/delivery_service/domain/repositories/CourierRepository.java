package ru.zifrkoks.delivery_service.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.zifrkoks.delivery_service.domain.models.courier.Courier;
import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;

public interface CourierRepository  extends JpaRepository<Courier,Long> {
    public Optional<Courier> findByUsername(String username);
    public Optional<UserAccount> findByEmail(String email);
    public Optional<UserAccount> findByPhone(String phone);
    @Query("select e from Courier e where e.username = :username and e.password = :password")
    public Optional<Courier> tryToAuthorize(@Param("username")String username,@Param("password")String password);
}
