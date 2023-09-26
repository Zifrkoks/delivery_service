package ru.zifrkoks.delivery_service.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Getter;
import lombok.Setter;
import ru.zifrkoks.delivery_service.domain.exceptions.SignUpException;
import ru.zifrkoks.delivery_service.domain.exceptions.SignUpException.SignUpStatus;
import ru.zifrkoks.delivery_service.domain.models.user.Basket;
import ru.zifrkoks.delivery_service.domain.models.user.UserAccount;
import ru.zifrkoks.delivery_service.domain.models.user.UserData;
import ru.zifrkoks.delivery_service.domain.repositories.UserRepository;
import ru.zifrkoks.delivery_service.domain.services.interfaces.UserService;
import ru.zifrkoks.delivery_service.domain.services.models.SignUpModel;

@Service
@Getter
@Setter
public class UserServiceImpl implements UserService {
    
    @Autowired
    UserRepository userRepository;
    
    @Override
    @Transactional
    public boolean signUp(SignUpModel request){
        UserAccount userAccount = new UserAccount();
        if(userRepository.findByUsername(request.username).isPresent())
        {
            return false;
            //throw new SignUpException(SignUpStatus.NAME_TAKEN);
        }
        try
        {
            userAccount.setUsername(request.username);
            userAccount.setPassword(request.password);
            userAccount.setEmail(request.email);
            userAccount.setPhone(request.phone);
            userAccount.setUserData(new UserData());
            userAccount.setBasket(new Basket());
            userAccount = userRepository.save(userAccount);
        }
        catch(Exception ex){
            return false;
        }
        return true;
    }

    
}
