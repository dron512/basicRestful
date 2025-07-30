package com.pmh.ex12.freeboard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pmh.ex12.common.BaseEntity;
import com.pmh.ex12.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private User user;

    @ManyToMany(mappedBy = "likedFreeBoards")
    @JsonIgnore
    private List<User> likedByUsers = new ArrayList<>();

    @Override
    public String toString() {
        return "FreeBoard{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                "} " + super.toString();
    }
}
