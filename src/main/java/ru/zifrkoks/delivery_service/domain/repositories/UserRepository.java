package ru.zifrkoks.delivery_service.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;




public interface UserRepository extends JpaRepository<UserAccount,Long> {
    public Optional<UserAccount> findByUsername(String username);
    public Optional<UserAccount> findByEmail(String email);
    public Optional<UserAccount> findByPhone(String phone);
    @Query("select e from UserAccount e where e.username = :username and e.password = :password")
    public Optional<UserAccount> tryToAuthorize(@Param("username")String username,@Param("password")String password);
}
