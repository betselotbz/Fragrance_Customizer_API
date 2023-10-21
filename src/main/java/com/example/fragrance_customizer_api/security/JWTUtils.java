package com.example.fragrance_customizer_api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.logging.Logger;

public class JWTUtils {
    Logger logger = Logger.getLogger(JWTUtils.class.getName());
    @Value("${jwt-secret}")
    private String jwtSecret;

    @Value("${jwt-expiration-ms}")
    private int jwtExpMs;

    public String generateJwtToken(MyUserDetails myUserDetails) {
        return Jwts.builder()
                .setSubject((myUserDetails.getUsername())) // just the user email
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpMs))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
}
