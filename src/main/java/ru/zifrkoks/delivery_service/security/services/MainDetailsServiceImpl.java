package ru.zifrkoks.delivery_service.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class MainDetailsServiceImpl implements UserDetailsService {
    private UserDatailsServiceImpl userDatailsServiceImpl;
    private StoreDetailsServiceImpl storeDetailsServiceImpl;
    private CourierDatailsServiceImpl courierDatailsServiceImpl;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails datails = null;

        try{
            datails = userDatailsServiceImpl.loadUserByUsername(username);
        }
        catch(Exception ex){

        }
        try{
            datails = storeDetailsServiceImpl.loadUserByUsername(username);
        }
        catch(Exception ex){
            
        }
        try{
            datails = courierDatailsServiceImpl.loadUserByUsername(username);
        }
        catch(Exception ex){
            
        }
        if(datails == null)
            throw new UsernameNotFoundException("User, courier or store with username = "+ username +" not exist!");
        
        return datails;
    }
    
}
