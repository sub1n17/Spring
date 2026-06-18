package org.example.ch04.dao;

import lombok.extern.slf4j.Slf4j;
import org.example.ch04.dto.User1DTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 실행 순서를 보장
class User1DAOTest {

    @Autowired
    private User1DAO dao;

    /*
        단위 테스트 케이스 작성
        - 애플리케이션 시나리오를 생각해서 테스트 케이스 로직 작성

     */

    @DisplayName("User1DAO - insert")
    @Test
    @Order(1)
    void insert() {
        // Given - 테스트 준비
        User1DTO dto = User1DTO.builder()
                    .userid("test01")
                    .name("테스트")
                    .hp("010-1111-1111")
                    .age(11)
                    .build();

        // When - 테스트 실행
        dao.insert(dto);

        // Then - 테스트 결과 확인, Assertion 단정문 사용
        User1DTO resultUser = dao.select(dto.getUserid());
        Assertions.assertEquals(dto.getUserid(), resultUser.getUserid());
    }

    @DisplayName("User1DAO - select")
    @Test
    @Order(2)
    void select() {
        // Given
        String userid = "test01";

        // When
        User1DTO user1DTO = dao.select(userid);

        // Then
        log.info(user1DTO.toString());
        assertEquals(userid, user1DTO.getUserid());

    }

    @DisplayName("User1DAO - selectAll")
    @Test
    @Order(3)
    void selectAll() {
        // When
        List<User1DTO> dtoList = dao.selectAll();

        // Then
        for(User1DTO dto : dtoList) {
            System.out.println(dto);
        }
        assertFalse(dtoList.isEmpty());
    }

    @DisplayName("User1DAO - update")
    @Test
    @Order(4)
    void update() {
        // Given
    User1DTO dto = User1DTO.builder()
                        .userid("test01")
                        .name("수정한테스트")
                        .hp("010-2222-2222")
                        .age(22)
                        .build();
        // When
        dao.update(dto);

        // Then
        User1DTO modifiedUser = dao.select(dto.getUserid());
        assertEquals(dto.getName(), modifiedUser.getName());
    }

    @DisplayName("User1DAO - delete")
    @Test
    @Order(5)
    void delete() {
        // Given
        String userid = "test01";

        // When
        dao.delete(userid);

        // Then
        User1DTO resultDTO = dao.select(userid);
        assertNull(resultDTO);
    }
}