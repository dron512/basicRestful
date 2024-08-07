package com.pmh.ex12.common;

import com.pmh.ex12.error.BizException;
import com.pmh.ex12.error.ErrorCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {
    
    private final TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getMethod().equals("OPTIONS"))
            return true;

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println(token);
        if( token ==null || !token.contains("Bearer "))
            throw new BizException(ErrorCode.NEED_TOKEN);

        token = token.split(" ")[1];
        Jws<Claims> jws = tokenManager.validateToken(token);

        if( !jws.getPayload().getSubject().equals("mhToken")){
            throw new BizException(ErrorCode.INVALID_TOKEN);
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
