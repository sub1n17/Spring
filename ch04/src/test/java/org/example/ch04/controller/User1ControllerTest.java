package org.example.ch04.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;


import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import  static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import  static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Slf4j
@SpringBootTest
@AutoConfigureMockMvc //
class User1ControllerTest {

    /*
        MockMvc
        - 웹 애플리케이션을 서버에 배포하지 않고 MVC 동작을 재현하기 위한 Mock 객체
     */

    @Autowired
    private MockMvc mockMvc;

    @Test
    void log() throws Exception {
        mockMvc.perform(get("/log")) // log로 get 요청
                .andExpect(status().is3xxRedirection()) // 리다이렉트(300) 확인
                .andDo(print()); // 테스트 결과 출력
    }

    @Test
    void list() throws Exception  {
        mockMvc.perform(get("/user1/list")) // GET:/user1/list 요청
                .andExpect(status().isOk()) // 요청성공(200) 확인
                .andExpect(view().name("user1/list")) // View(/user1/list.html) 확인
                .andDo(print()); // 테스트 결과 리포트
    }

    @Test
    void register() throws Exception {
        // POST:register 테스트

        // 반복문으로 대량 트래픽 연출
        for(int i=1; i<=10000; i++) {
            mockMvc.perform(
                            post("/user1/register")
                                    .param("userid", "test11")
                                    .param("name", "테스트11")
                                    .param("hp", "010-1111-1111")
                                    .param("age", "11")
                    )
                    .andExpect(status().is3xxRedirection())
                    .andDo(print());
        }
    }

    @Test
    void testRegister() {
    }

    @Test
    void modify() {
    }

    @Test
    void testModify() throws Exception {


    }

    @Test
    void remove() throws Exception {

        mockMvc.perform(
                        get("/user1/remove")
                                .param("userid", "test11")
                )
                .andExpect(status().is3xxRedirection())
                .andDo(print());
    }
}