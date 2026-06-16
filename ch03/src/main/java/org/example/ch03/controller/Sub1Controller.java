package org.example.ch03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 사용자 요청을 처리하는 컨트롤러 생성
@Controller
public class Sub1Controller {

    @GetMapping("/sub1/hello")
    public String hello() {
        // 반환되는 문자열 뒤에 확장자 .html 붙고, 해당 문자열로 디스패처에서 forward됨
        return "/sub1/hello";
    }

    @GetMapping(value= {"/sub1/welcome"}) // 디폴트
    public String welcome() {
        return "/sub1/welcome";
    }

    @GetMapping("/sub1/greeting")
    public String greeting() {
        return "/sub1/greeting";
    }

}
