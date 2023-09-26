package ru.zifrkoks.delivery_service.domain.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.zifrkoks.delivery_service.domain.models.store.Store;
import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;

public interface StoreRepository extends JpaRepository<Store,Long> {
    public Optional<Store> findByUsername(String username);
    public Optional<Store> findByEmail(String email);
    public Optional<Store> findByPhone(String phone);
    
    public Optional<Store> tryToAuthorize(@Param("username")String username,@Param("password")String password);
    @Query("select u from UserAccount u where u.favoriteStores = (select s.id from Store s where s.username = :username)")
    public HashSet<UserAccount> usersMarksStores(@Param("username")String storeUsername);
    @Query("select u form UserAccount u where u.favoriteProducts = (select s.products from Store s where s.username = :username)")
    public HashSet<UserAccount> usersMarksProductsByStore(String storeUsername);
}
