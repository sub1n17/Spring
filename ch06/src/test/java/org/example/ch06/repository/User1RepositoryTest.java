package org.example.ch06.repository;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.example.ch06.dto.User1DTO;
import org.example.ch06.entity.User1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository repository;

    @Test
    void findByUserid() {
        User1 entity = repository.findByUserid("A102");
        log.info(entity.toString());
    }

    @Test
    void findByName() {
        List<User1> entityList = repository.findByName("김춘추");
        log.info(entityList);
    }

    @Test
    void findByNameNot() {
        List<User1> entityList = repository.findByNameNot("김춘추");
        log.info(entityList);
    }

    @Test
    void findByUseridAndName() {
        User1 entity = repository.findByUseridAndName("A102", "김춘추");
        log.info(entity);
    }

    @Test
    void findByUseridOrName() {
        List<User1> entityList =repository.findByUseridOrName("A102", "장보고");
        log.info(entityList);
    }

    @Test
    void findByHp() {
        List<User1> entityList = repository.findByHp("010-1234-2222");
        log.info(entityList);
    }

    @Test
    void findByAgeGreaterThan() {
        List<User1> entityList = repository.findByAgeGreaterThan(20);
        log.info(entityList);
    }

    @Test
    void findByAgeGreaterThanEqual() {
        List<User1> entityList = repository.findByAgeGreaterThanEqual(20);
        log.info(entityList);
    }

    @Test
    void findByAgeLessThan() {
        List<User1> entityList = repository.findByAgeLessThan(20);
        log.info(entityList);
    }

    @Test
    void findByAgeLessThanEqual() {
        List<User1> entityList = repository.findByAgeLessThanEqual(20);
        log.info(entityList);
    }

    @Test
    void findByAgeBetween() {
        List<User1> entityList = repository.findByAgeBetween(20, 25);
        log.info(entityList);
    }

    @Test
    void findByNameLike() {
        List<User1> entityList = repository.findByNameLike("김춘추");
        log.info(entityList);
    }

    @Test
    void findByNameContains() {
        List<User1> entityList = repository.findByNameContains("김");
        log.info(entityList);
    }

    @Test
    void findByNameStartingWith() {
        List<User1> entityList = repository.findByNameStartingWith("김춘");
        log.info(entityList);
    }

    @Test
    void findByNameEndsWith() {
        List<User1> entityList = repository.findByNameEndsWith("고");
        log.info(entityList);
    }

    @Test
    void findByOrderByName() {
        List<User1> entityList = repository.findByOrderByName();
        log.info(entityList);
    }

    @Test
    void findByOrderByAgeAsc() {
        List<User1> entityList = repository.findByOrderByAgeAsc();
        log.info(entityList);
    }

    @Test
    void findByOrderByAgeDesc() {
        List<User1> entityList = repository.findByOrderByAgeDesc();
        log.info(entityList);
    }

    @Test
    void findByAgeGreaterThanOrderByAgeDesc() {
        List<User1> entityList = repository.findByAgeGreaterThanOrderByAgeDesc(15);

        log.info(entityList);
    }

    @Test
    void countByUserid() {
        int entity = repository.countByUserid("A102");
        log.info(entity);
    }

    @Test
    void countByName() {
        int entity = repository.countByName("김춘추");
        log.info(entity);
    }

    @Test
    void selectUnderAge30() {
        List<User1> entityList = repository.selectUnderAge30();
        log.info(entityList);

    }

    @Test
    void selectByName() {
        List<User1> entityList =repository.selectByName("장보고");
        log.info(entityList);

    }

    @Test
    void selectByUserid() {
        List<Object[]> objList = repository.selectByUserid("A102");
    }

    @Test
    void selectParentChild() {
    }
}