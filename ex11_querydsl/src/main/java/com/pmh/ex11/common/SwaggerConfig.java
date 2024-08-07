package com.pmh.ex11.common;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "RESTFUL USER FREEBOARD",
            description = "사용자 조회 추가 수정 삭제\n 게시글 조회추가 수정 삭제",
                version = "v1.0.0")
)
@SecurityScheme(
        name="Bearer Authentication)",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class SwaggerConfig {
}
