package com.ims.ims_backend.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtUtil {
    private static final String SECRET = "mysecretekey";

    public static String generateToken(String username){ //creates JWT token after login
        return Jwts.builder()
                .setSubject(username) //this one stores username inside the token
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+86400000)) //this token will expire after 24 hours
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }
    public static String extractUsername(String token){ //This extract username from the token.
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
