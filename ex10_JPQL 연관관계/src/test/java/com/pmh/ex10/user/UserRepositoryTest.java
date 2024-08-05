package com.pmh.ex10.user;

import com.pmh.ex10.freeboard.FreeBoard;
import com.pmh.ex10.freeboard.FreeBoardRepository;
import com.pmh.ex10.user.userprofile.UserProfile;
import com.pmh.ex10.user.userprofile.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired UserRepository userRepository;
    @Autowired FreeBoardRepository freeBoardRepository;
    @Autowired UserProfileRepository userProfileRepository;

    @Test
    void jpaQueryTest() {
        Optional<User> optionalUser = userRepository.findByName("홍길동");
        optionalUser.ifPresent(System.out::println);

        Optional<User> jpqloptionalUser = userRepository.jpqlFindByName("홍길동");
        jpqloptionalUser.ifPresent(System.out::println);

        Optional<User> njpqloptionalUser = userRepository.njpqlFindByName("홍길동");
        njpqloptionalUser.ifPresent(System.out::println);
    }

    @Test
    void jpaQueryTest2() {
        Optional<User> optionalUser = userRepository.findByNameOrEmail("","aaa@naver.com");
        optionalUser.ifPresent(System.out::println);

        Optional<User> jpqloptionalUser = userRepository.jpqlfindByNameOrEmail("","aaa@naver.com");
        jpqloptionalUser.ifPresent(System.out::println);
    }

    @Test
    void jpaQueryTest3() {
        List<User> list = userRepository.findByNameContainingOrderByIdDesc("동");
        list.stream().forEach(System.out::println);
    }

    @Test
    void oneTooneTest(){
        Optional<User> user = userRepository.findByName("홍길동");

        UserProfile userProfile = UserProfile.builder()
                .address("대구")
                .phoneNumber("01012341234")
                .user(user.get())
                .build();

        userProfileRepository.save(userProfile);

        userRepository.delete(user.get());
    }

    @Test
    void oneTomanyTest(){
        User user = userRepository.findById(2l).orElseThrow();

        System.out.println(user);
        System.out.println(user.getList());
    }

    @Test
    void oneTomanyCascadeTest(){
        User user = userRepository.findById(2l).orElseThrow();

        List<FreeBoard> list = user.getList();

        list.add(
                FreeBoard.builder()
                        .title("새로운글")
                        .content("새로운 테스트")
                        .author("새로운사람")
                        .user(user)
                .build());

        list.remove(1);

        userRepository.save(user);

    }


    @Test
    void userlikedFreeboard() {

        FreeBoard freeBoard2 = freeBoardRepository.findById(2l).orElseThrow();
        FreeBoard freeBoard3 = freeBoardRepository.findById(3l).orElseThrow();
        User user = userRepository.findById(2l).orElseThrow();

        List<FreeBoard> list = Arrays.asList(freeBoard2,freeBoard3);

        user.setLikedFreeBoards(list);
        userRepository.save(user);
    }
}