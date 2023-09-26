package ru.zifrkoks.delivery_service.security.services;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import ru.zifrkoks.delivery_service.security.models.JWTUser;


public class JWTProvider {
    @Value("${app.jwt.secret}")
    String secret;
    @Value("${app.jwt.issuer}")
    String issuer;
    Algorithm algorithm;
    JWTVerifier verifier;
    /**
     * 
     */
    public JWTProvider() {
        algorithm = Algorithm.HMAC512(secret);
        verifier = JWT.require(algorithm)
        .withIssuer(issuer)
        .build();
    }

    public String generateToken(JWTUser user){
        String token = JWT.create()
        .withIssuer(issuer)
        .withExpiresAt(new Date(System.currentTimeMillis() + 600000L))
        .withIssuedAt(new Date())
        .withClaim("username", user.getUsername())
        .withClaim("role", user.getRole())
        .withJWTId(UUID.randomUUID().toString())
        .sign(algorithm);
        return token;
    } 
    
    public JWTUser verifyToken(String token){
        try {
            DecodedJWT jwt = verifier.verify(token);
            return JWTUser.builder()
            .username(jwt.getClaim("username").toString())
            .role(jwt.getClaim("role").toString())
            .build();
        } catch (JWTVerificationException e) {
            return null;
        }   
    } 
}
