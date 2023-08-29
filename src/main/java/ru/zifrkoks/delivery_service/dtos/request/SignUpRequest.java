package ru.zifrkoks.delivery_service.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SignUpRequest {

    @NotBlank(message = "username is empty")
    @Min(5)
    @Max(30)
    public String username;


    @NotBlank(message = "password is empty")
    @Min(5)
    @Max(30)
    public String password;


    @NotBlank(message = "email is empty")
    @Email
    public String email;

    
    @NotBlank(message = "phone is empty")
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$")
    //for numbers show +111 (202) 555-0125
    public String phone;

    
}
