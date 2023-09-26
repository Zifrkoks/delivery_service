package ru.zifrkoks.delivery_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.Data;
import ru.zifrkoks.delivery_service.domain.services.impl.UserServiceImpl;
import ru.zifrkoks.delivery_service.domain.services.models.SignUpModel;

@Controller
@Data
public class UserController {
    @Autowired
    UserServiceImpl userService;
    
    public ResponseEntity<String> signUp(@RequestBody SignUpModel request){
    if(userService.signUp(request))
    {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    else
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
