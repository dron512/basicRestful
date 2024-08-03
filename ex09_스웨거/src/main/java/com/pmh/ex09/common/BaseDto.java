package com.pmh.ex09.common;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class BaseDto {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String regName;
    private String modName;
}
