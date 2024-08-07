package com.pmh.ex12.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pmh.ex12.common.BaseEntity;
import com.pmh.ex12.freeboard.FreeBoard;
import com.pmh.ex12.user.userprofile.UserProfile;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
//@ToString
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                "} " + super.toString();
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserProfile userProfile;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER
            ,cascade = CascadeType.ALL
            ,orphanRemoval = true)
    private List<FreeBoard> list;


    @ManyToMany
    @JoinTable(
            name="user_freeboard_likes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "freeboard_id")
    )
    @JsonIgnore
    private List<FreeBoard> likedFreeBoards = new ArrayList<>();
}
