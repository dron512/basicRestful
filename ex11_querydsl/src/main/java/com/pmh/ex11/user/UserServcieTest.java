package com.pmh.ex11.user;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServcieTest {

    private final EntityManager entityManager;
    private final UserRepository userRepository;

    @Transactional
    public void userTest(){

        User user = User.builder()
                .name("최길동")
                .email("eee@naver.com")
                .build();

        User dbUser = userRepository.save(user);

        System.out.println(entityManager.contains(user));
        System.out.println(entityManager.contains(dbUser));

        user.setName("이길동");
    }

}
