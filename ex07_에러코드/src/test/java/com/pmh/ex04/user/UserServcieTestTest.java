package com.pmh.ex04.user;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServcieTestTest {

    @Autowired
    UserServcieTest userServcieTest;

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;


    @Test
    @Transactional
    void userTest() throws Exception{

//        userServcieTest.userTest();

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