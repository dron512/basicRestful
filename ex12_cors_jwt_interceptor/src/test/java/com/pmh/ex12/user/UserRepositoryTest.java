package com.pmh.ex12.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    UserRepository userRepository;

    @Test
    void testFindUsersByName() {
        // given
        QUser qUser = QUser.user;

        // when
        List<User> list = jpaQueryFactory.selectFrom(qUser)
                .where(qUser.name.contains("길동"))
                .fetch();

        System.out.println(list);

        Assertions.assertThat(list).hasSize(3);
        Assertions.assertThat(list.get(0).getName()).contains("길동");
        Assertions.assertThat(list.get(1).getName()).contains("길동");
    }

    @Test
    void testFindUsersByNamePredicate() {
        // given
//        QUser qUser = QUser.user;
//        BooleanExpression predicate = qUser.name.contains("길동");
//        Pageable pageable = PageRequest.of(0,2);
//
//        // when
//        Page<User> list = userRepository.findAll(predicate,pageable);
//
//        System.out.println(list.getContent());
//
//        Assertions.assertThat(list).hasSize(2);
//        list.forEach( user -> Assertions.assertThat(user.getName()).contains("길동"));
//
//        pageable = PageRequest.of(1,2);
//
//        // when
//        list = userRepository.findAll(predicate,pageable);
//
//        System.out.println(list.getContent());
//
//        //then
//        Assertions.assertThat(list).hasSize(1);
//        list.forEach( user -> Assertions.assertThat(user.getName()).contains("길동"));
    }
}