package com.pmh.ex10.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
public class BaseDto {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String regName;
    private String modName;
}
