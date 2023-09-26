package ru.zifrkoks.delivery_service.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ru.zifrkoks.delivery_service.domain.models.store.Store;
import ru.zifrkoks.delivery_service.domain.repositories.StoreRepository;
import ru.zifrkoks.delivery_service.security.models.CastomUserDatails;

@Component
public class StoreDetailsServiceImpl implements UserDetailsService {

    StoreRepository storeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Store userAccount = storeRepository.findByUsername(username)
        .orElseThrow(()-> new UsernameNotFoundException("Store with username = "+ username +" not exist!"));
        return new CastomUserDatails(userAccount);
    }
    
}
