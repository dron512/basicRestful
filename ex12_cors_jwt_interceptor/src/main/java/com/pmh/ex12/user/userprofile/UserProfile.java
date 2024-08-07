package com.pmh.ex12.user.userprofile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pmh.ex12.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String phoneNumber;

    @OneToOne
    @JsonIgnore
    private User user;
}
