package com.pmh.ex12.login;

import com.pmh.ex12.common.TokenManager;
import com.pmh.ex12.error.BizException;
import com.pmh.ex12.error.ErrorCode;
import com.pmh.ex12.user.User;
import com.pmh.ex12.user.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name="Bearer Authentication")
public class LoginController {

    private final TokenManager tokenManager;
    private final UserRepository userRepository;

    @GetMapping("tokenPrint")
    public void test(){
        tokenManager.getTokenKeyPrint();
    }

    @GetMapping("login")
    public String login(@RequestParam("name") String name, @RequestParam("email") String email){
        User user = userRepository.findByNameOrEmail(name,email).orElseThrow(
                () -> new BizException(ErrorCode.INCORRECT_NAME_AND_EMAIL)
        );
        return tokenManager.generateToken(user);
    }

    @GetMapping("jwtvalidate")
    public String jwtvalidate(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        System.out.println(token);
        Jws<Claims> jws = tokenManager.validateToken(token.split(" ")[1]);
        return "정상토큰 "+jws.getPayload().getSubject();
    }
}
