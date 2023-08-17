package ru.zifrkoks.delivery_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.zifrkoks.delivery_service.models.user.User;


public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    @Query("select e from users where e.username = :username and e.password = :password")
    public User tryToAuthorize(@Param("username")String username,@Param("password")String password);
}
