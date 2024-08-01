package com.pmh.ex04.user;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTestService {

    private final EntityManager entityManager;
    private final UserRepository userRepository;

    @Transactional
    public void testUser(){
        User user1 = User.builder().name("이길").email("ddd@naver.com").build();
        User dbUser1 = userRepository.save(user1); // Persist (New -> Persist)

        System.out.println(entityManager.contains(dbUser1));
        System.out.println(entityManager.contains(user1));

        dbUser1.setName("변경감지");
        user1.setName("벼겨겨경감지");
    }
}
