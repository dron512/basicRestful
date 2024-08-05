package com.pmh.ex10.freeboard;

import com.pmh.ex10.user.User;
import com.pmh.ex10.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FreeBoardRepositoryTest {

    @Autowired
    FreeBoardRepository freeBoardRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("게시판insert테스트")
    void freeBoardSaveTest() {
        User user= userRepository.findById(2l).orElseThrow();

        FreeBoard freeBoard = FreeBoard.builder()
                .title("제목")
                .content("내용")
                .author("홍길동")
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard);

        FreeBoard freeBoard1 = FreeBoard.builder()
                .title("제목111")
                .content("내용111")
                .author("홍길동")
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard1);

        FreeBoard freeBoard2 = FreeBoard.builder()
                .title("제목222")
                .content("내용222")
                .author("홍길동")
                .user(user)
                .build();

        freeBoardRepository.save(freeBoard2);
    }

    @Test
    @DisplayName("게시판select테스트")
    void freeBoardSelectTest(){
        FreeBoard freeBoard = freeBoardRepository.findById(1l).orElseThrow();
        System.out.println(freeBoard.getUser());
//        Assertions.assertThat(freeBoard)
//                .isNotNull();
//        Assertions.assertThat(freeBoard.getContent())
//                .isEqualTo("내용sodlaskdjfn");
    }
}