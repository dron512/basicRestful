package com.pmh.ex08.freeboard;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FreeBoardRequestDto {

    private Long id;

    @NotBlank(message="제목은 공백일 수 없습니다.")
    private String title;

    @NotBlank(message="내용은 공백일 수 없습니다.")
    private String content;

    @NotBlank(message="작성자는 공백일 수 없습니다.")
    private String author;

}
