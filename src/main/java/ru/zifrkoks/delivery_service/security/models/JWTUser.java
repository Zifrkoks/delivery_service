package ru.zifrkoks.delivery_service.security.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JWTUser {

    public String role;

    public String username;

}
