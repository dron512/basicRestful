package com.pmh.ex12.common;

import com.pmh.ex12.error.BizException;
import com.pmh.ex12.error.ErrorCode;
import com.pmh.ex12.user.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class TokenManager {

    @Value("${mh.token.key}")
    private String tokenkey;

    public void getTokenKeyPrint(){
        System.out.println("tokenkey = "+tokenkey);
    }

    public String generateToken(User user){
        return Jwts.builder()
                .subject("mhToken")
                .claim("name",user.getName())
                .claim("email",user.getEmail())
                .signWith(Keys.hmacShaKeyFor(tokenkey.getBytes(StandardCharsets.UTF_8)))
                .expiration(new Date(System.currentTimeMillis()+1000*60*15))
                .compact();
    }

    public Jws<Claims> validateToken(String token){
        try{
            Jws<Claims> jws = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(tokenkey.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseSignedClaims(token);
            return jws;
        }
        catch (ExpiredJwtException e){
            throw new BizException(ErrorCode.VALIDITY_PERIOD_EXPIRED);
        }
        catch (Exception e){
            throw new BizException(ErrorCode.INVALID_TOKEN);
        }
    }
}
