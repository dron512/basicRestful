package com.pmh.ex12.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDto {
    private long id;

    @NotBlank(message = "이름은 공백일 수 없습니다.")
    @Schema(description = "name을 넣으셔야 합니다.",example = "최길동")
    private String name;

    @NotBlank(message = "이메일은 공백일 수 없습니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    @Schema(description = "email을 넣으셔야 합니다.",example = "eee@naver.com")
    private String email;
}
