package ru.zifrkoks.delivery_service.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import ru.zifrkoks.delivery_service.domain.models.courier.Courier;
import ru.zifrkoks.delivery_service.domain.repositories.CourierRepository;
import ru.zifrkoks.delivery_service.security.models.CastomUserDatails;

@Component
public class CourierDatailsServiceImpl implements UserDetailsService {

    CourierRepository courierRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Courier userAccount = courierRepository.findByUsername(username)
        .orElseThrow(()-> new UsernameNotFoundException("Courier with username = "+ username +" not exist!"));
        return new CastomUserDatails(userAccount);
    }
    
}
