package com.example.tatu;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.nio.charset.StandardCharsets;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "mdkoamsdklalkdlakemdklemkfmseklfeosio332!!!!we21qPDAOW456";

    public static String generateToken(String email) {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String extractEmail(String token) {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.getJcaName());
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Add this method to extract username from JWT token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        Key key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), SignatureAlgorithm.HS256.getJcaName());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()));
    }

    // ...otros métodos...
}