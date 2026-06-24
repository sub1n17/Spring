package org.example.ch08.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.ch08.dto.User1DTO;
import org.example.ch08.service.User1Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
public class User1Controller {

    private final User1Service service;

    /*
        @RestController
        - 요청 메서드로 API로 처리하기 위한 Controller 어노테이션
        - 요청 메서드에 @ResponseBody를 생략

        @ResponseBody
        - 메서드 반환값을 응답객체 body로 출력
        - 반환값을 JSON 데이터로 출력

        @RequestBody
        - 요청 객체 본문에 포함된 데이터를 JAVA 객체로 반환
        - 사용자가 전송하는 JSON 데이터를 수신처리

        @PathVariable
        - API(URI 주소)에 포함된 데이터를 수신 처리

        ResponseEntity
        - API를 요청한 사용자에게 응답 데이터를 구성해서 부가적인 정보를 제공하는 클래스
        - 사용자 정의응답 객체를 생성하기 때문에 프론트 개발 활용도 향상
    */

    @PostMapping("/user1")
    public ResponseEntity<User1DTO> register(@RequestBody User1DTO dto) {
        log.info(dto);

        User1DTO savedUser1 = service.register(dto);

        // 응답 객체 생성
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser1);
    }

    // @ResponseBody
    @GetMapping("/user1")
    public ResponseEntity<List<User1DTO>> list() {

        List<User1DTO> dtoList = service.getUserAll();

        return ResponseEntity.status(HttpStatus.OK).body(dtoList);
    }

    // @ResponseBody
    @PutMapping("/user1")
    public ResponseEntity<User1DTO> modify(@RequestBody User1DTO dto) {
        log.info(dto);

        User1DTO modifiedUser1 = service.modify(dto);

        return ResponseEntity.ok(modifiedUser1);
    }

    // @ResponseBody
    @DeleteMapping("/user1/{userid}")
    public ResponseEntity<Map<String, Boolean>> remove(@PathVariable("userid") String userid) {
        log.info(userid);

        boolean result = service.remove(userid);

        return ResponseEntity.ok(Map.of("result", result));
    }
}