package ru.zifrkoks.delivery_service.services.Interfaces;

import org.springframework.stereotype.Service;




@Service
public interface UserService {
    
    public boolean signUp(SignUpDto signUp);

    public boolean signIn(SignInDto signIn);

    public boolean signOut(SignOutDto signOut);
}
