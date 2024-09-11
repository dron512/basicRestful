package com.pmh.ex07.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    public void insertData(){
        // given
        userRepository.save(
                User.builder()
                        .email("ddd@naver.com")
                        .name("김길동")
                .build());
    }

    @AfterEach
    public void deleteData(){
        userRepository.deleteById(4l);
    }

    @Test
    void selectall() throws Exception {

        String url ="/user/selectall";

        // when
        ResultActions resultActions = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        //then
        resultActions
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void selectOne() throws Exception {
        String url ="/user/select/1";

        // when
        ResultActions resultActions = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        //then
        resultActions
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void objectMapperTest() throws JsonProcessingException {

        User user = User.builder()
                .name("상길동")
                .email("rr@naver.com")
                .build();

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(user);
        System.out.println(json);

    }

    @Test
    void insert() throws Exception {
        // given
        String url ="/user/insert";

        User user = User.builder()
                .name("상길동")
                .email("rr@naver.com")
                .build();

        ObjectMapper om = new ObjectMapper();
        String userJson = om.writeValueAsString(user);
//        String userJson = """
//                           {"id":5,"name":"최길동","email":"eee@naver.com"}
//                          """;

        // when
        ResultActions resultActions = mockMvc.perform(post(url)
                        .content(userJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        //then
        resultActions
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void update() throws Exception {
        // given
        String url ="/user/update";

        User user = User.builder()
                .id(2l)
                .name("상길동")
                .email("rr@naver.com")
                .build();

        ObjectMapper om = new ObjectMapper();
        String userJson = om.writeValueAsString(user);

        // when
        ResultActions resultActions = mockMvc.perform(put(url)
                .content(userJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        //then
        resultActions
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void deleteTest()throws Exception {
        // given
        String url ="/user/delete/1";

        // when
        ResultActions resultActions = mockMvc.perform(delete(url));

        //then
        resultActions
                .andExpect(status().isOk())
                .andDo(print());
    }
}