package ru.zifrkoks.delivery_service.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;
import ru.zifrkoks.delivery_service.domain.repositories.UserRepository;
import ru.zifrkoks.delivery_service.security.models.CastomUserDatails;

@Component
public class UserDatailsServiceImpl implements UserDetailsService {

    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userRepository.findByUsername(username)
        .orElseThrow(()-> new UsernameNotFoundException("User with username = "+ username +" not exist!"));
        return new CastomUserDatails(userAccount);
    }
    
}
