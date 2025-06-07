package com.example.E_commerce.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private static String SECRET_KEY = "4055edd7ac3c0432052bcd8241" +
            "941eb916d0db7f738f036196b105360032f45" +
            "02f7624e9444b246b38da152cd2b96536b64d" +
            "75763b0bd599b455116bfb944489a6ccdd0df" +
            "bc90115efbb38de1b8ef649f4dfe3c99a83d92" +
            "bc16d5bc4520015b8f069f2025f447b0cefef1" +
            "346d63c2854b1af3da6101e73a781465174010" +
            "083b333ebe3e9e92d8cd552869adce8a5c1d2d83b" +
            "bf1e737268f2c744393e8b816888e5049eb85e7c462aef8495274002aaa2d31c" +
            "0b82b6ed5c5826554e07b311a946086e192ff5f65f96a76f3759bf33c25123d630f143c77" +
            "0893ffc2279d48e11242922e5816169fa2b1647685502f9985d2fda6400c3947dac6c204a4e7199a04f";

    public String generateToken(UserDetails userDetails){
        String role = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(", "));
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("role",role)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*24))
                .signWith(getSigneKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getSigneKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String extractUsername(String jwt){
        return extractClaim(jwt,Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSigneKey())
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }



}
