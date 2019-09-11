package com.ajs.apppush.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ajs.apppush.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

    @Value("${grokonez.app.jwtSecret}")
    private String secret;
    
    public String generateAccessToken(User user) {
    	Map<String, Object> claims = new HashMap<>();
    	
    	claims.put("email", user.getEmail());
    	
    	return doGenerateToken(claims, user.getUserId(), 1000);
    }
    
    public String generateRefreshToken() {
    	Map<String, Object> claims = new HashMap<>();

    	return doGenerateToken(claims, null, 100000);
    }
    
    private String doGenerateToken(Map<String, Object> claims, String subject, int expiration) {
    	
    	return Jwts.builder()
    			.setClaims(claims)
    			.setSubject(subject)
    			.setIssuedAt(new Date())
    			.setExpiration(new Date((new Date()).getTime() + expiration))
    			.signWith(SignatureAlgorithm.HS512, secret)
    			.compact();
    }
    
    public String getUserNmFromJwtToken(String token, String key) {
        return String.valueOf(Jwts.parser()
			                .setSigningKey(secret)
			                .parseClaimsJws(token)
			                .getBody().get(key));

	}
}
