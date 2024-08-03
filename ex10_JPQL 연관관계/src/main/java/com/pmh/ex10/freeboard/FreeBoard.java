package com.pmh.ex10.freeboard;

import com.pmh.ex10.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class FreeBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false,length = 1000)
    private String content;

    @Column(nullable = false,length = 50)
    private String author;

    @Builder
    public FreeBoard(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
