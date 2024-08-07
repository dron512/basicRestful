package com.pmh.ex11.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pmh.ex11.common.BaseDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto extends BaseDto {
    private long id;

    private String name;

    private String email;
}
