package com.pmh.ex09.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pmh.ex09.common.BaseDto;
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
