package com.pmh.ex04;


import com.pmh.ex04.user.User;
import com.pmh.ex04.user.UserRepository;
import com.pmh.ex04.user.UserTestService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EntityManagerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTestService userTestService;

    @Test
    void userTest(){
        userTestService.testUser();
    }

    @Test
    // 테스트 코드에서 @Transactional은 초기화 용도로 사용되어진다.
    @Transactional
    void userEntity() {
        User user1 = User.builder().name("이길").email("ddd@naver.com").build();
        User dbUser1 = userRepository.save(user1); // Persist (New -> Persist)

        System.out.println(em.contains(dbUser1));
        System.out.println(em.contains(user1));

        dbUser1.setName("변경감지");
        user1.setName("벼겨겨경감지");

    }
}
