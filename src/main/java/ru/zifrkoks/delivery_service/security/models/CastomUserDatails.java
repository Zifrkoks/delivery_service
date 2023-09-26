package ru.zifrkoks.delivery_service.security.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.zifrkoks.delivery_service.domain.models.courier.Courier;
import ru.zifrkoks.delivery_service.domain.models.store.Store;
import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;

@AllArgsConstructor
public class CastomUserDatails implements UserDetails  {

    public CastomUserDatails(UserAccount account){
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.role = "USER";
    }
    public CastomUserDatails(Courier account){
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.role = "COURIER";
    }
    public CastomUserDatails(Store account){
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.role = "STORE";
    }
    @Getter
    private String username;
    @Getter
    private String password;
    @Getter
    @Setter
    private String role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
